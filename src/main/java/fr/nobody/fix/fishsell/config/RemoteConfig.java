package fr.nobody.fix.fishsell.config;

import fr.nobody.fix.fishsell.FishSell;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteConfig {
    private FileConfiguration f; // config.yml
    // for support hex color in >1.16
    private static final Pattern HEX_PATTERN = Pattern.compile("(#\\w{6})");

    public RemoteConfig() {
        // load config file
       reloadConfig();
    }

    public Double ifFish(ItemStack fish){
        if(fish != null && fish.hasItemMeta()){
            PersistentDataContainer container = fish.getItemMeta().getPersistentDataContainer();
            if(!container.isEmpty()){
                Plugin pl = Bukkit.getPluginManager().getPlugin("NoOneFishing");
                // Price can be null when OneFishing do some weird thing
                NamespacedKey nbtprice = new NamespacedKey(pl, "nf-fish-price");
                NamespacedKey nbtweight = new NamespacedKey(pl, "nf-fish-weight");
                NamespacedKey nbtrarity = new NamespacedKey(pl, "nf-fish-rarity");


                Float weight = container.get(nbtweight, PersistentDataType.FLOAT);
                String rarity = container.get(nbtrarity, PersistentDataType.STRING);
                Double pr = container.getOrDefault(nbtprice, PersistentDataType.DOUBLE, -1.0);
                Double d = f.getDouble("raritymod."+ rarity);
                if (pr > 0) {
                    String formula = f.getString("settings.priceformula").replace("{price}", pr.toString()).replace("{weight}", weight.toString()).replace("{raritymod}", d.toString());
                    Double price = (new ExpressionBuilder(formula)).build().evaluate();
                    return price;
                } else return -1.0;

            }else return -1.0;
        } else return -1.0;
    }

    public void sellfish(Player p){
        AtomicReference<Double> z = new AtomicReference<>(0.0);
        AtomicReference<Integer> c = new AtomicReference<>(0);
        ItemStack[] contents = p.getInventory().getStorageContents();

        if(FishSell.getInstance().getConfig().getBoolean("fix.slot.head", false)){
            contents = (ItemStack[]) ArrayUtils.add(contents, p.getInventory().getHelmet());
        }
        if(FishSell.getInstance().getConfig().getBoolean("fix.slot.offhand", false)){
            contents = (ItemStack[]) ArrayUtils.add(contents, p.getInventory().getItemInOffHand());
        }
        System.out.println("Content size: "+contents.length);

        Arrays.stream(contents).forEach(itemStack -> {
            if(itemStack != null){
                Double d =  FishSell.getInstance().getRemoteConfig().ifFish(itemStack);
                if(d != -1.0){
                    if(itemStack.getAmount() > 1){
                        z.updateAndGet(v -> v + d * itemStack.getAmount());
                    } else {
                        z.updateAndGet(v -> v + d );
                    }
                    c.updateAndGet(v -> v + itemStack.getAmount());
                    boolean action = false;
                    if(FishSell.getInstance().getConfig().getBoolean("fix.slot.offhand", false) || FishSell.getInstance().getConfig().getBoolean("fix.slot.head", false)){
                        if(itemStack.isSimilar(p.getInventory().getItemInOffHand())){
                            p.getInventory().setItemInOffHand(null); // set air
                            action = true;
                        }
                        if(itemStack.isSimilar(p.getInventory().getHelmet())){
                            p.getInventory().setHelmet(null); // set air
                            action = true;
                        }
                    }
                    if(!action){
                        p.getInventory().remove(itemStack);
                    }
                }
            }
        });
        String s = FishSell.getInstance().getRemoteConfig().getConfig().getString("msg.sell").replace("%count%", c.get().toString()).replace("%price%", String.format("%.2f", z.get()));
        if(z.get() != 0.0){
            EconomyResponse e=  FishSell.getEcon().depositPlayer(p, z.get());
            if(e.transactionSuccess()){
                p.sendMessage(colorize(s));
            } else {
                p.sendMessage(e.errorMessage);
            }
        }
    }

    // For use the hex color. work >1.13
    public static String colorize(String message) {
        Matcher matcher = HEX_PATTERN.matcher(ChatColor.translateAlternateColorCodes('&', message));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group(1)).toString());
        }

        return matcher.appendTail(buffer).toString();
    }


    public void reloadConfig(){
        // Use file.separator to avoid Unix path problem.
        f = YamlConfiguration.loadConfiguration(new File(FishSell.getInstance().getDataFolder() + "/../NoOneFishing/config.yml".replace("/", File.separator)));
    }


    public FileConfiguration getConfig() {
        return f;
    }
}
