package fr.nobody.fix.fishsell.config;

import fr.nobody.fix.fishsell.FishSell;
import fr.nobody.fix.fishsell.data.Fish;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FishConfig {
    File file;
    ArrayList<Fish> fishes = new ArrayList<>();

    public FishConfig(){
        reloadConfig();
    }


    public void reloadConfig(){
        file = new File(FishSell.getInstance().getDataFolder() + "/../NoOneFishing/drops.yml".replace("/",File.separator));
        loadFishes();
    }

    private void loadFishes(){
        if(file == null){
            FishSell.getInstance().getLogger().warning("Cannot load fishes !");
            return;
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection sec = config.getConfigurationSection("drops");

        for (String key : sec.getKeys(false)) {

            FishSection f = new FishSection(key, sec);
            String fishName = f.g("name");
            List<String> fishLores = f.g("lore");
            Double minweight = f.g("minimal-weight");
            Double maxweight = f.g("maximum-weight");
            List<String> biomes = f.g("biome");
            String material = f.g("material");
            String rarity = f.g("rarity");
            Boolean glow = f.g("glow");
            Boolean shiny = f.g("shiny");
            Boolean hideEnchant =f.g("hideenchants");
            List<String> echantes = f.g("enchants");

            Fish fish = new Fish(fishName, fishLores, minweight, maxweight, biomes, material, rarity, glow, shiny, hideEnchant, echantes);
            fish.name = key;

            if(f.has("texture")){
                System.out.println(key);
            }
        }
    }

}

class FishSection{
    private String key;
    private ConfigurationSection section;

    public FishSection(String key, ConfigurationSection section){
        this.key = key;
        this.section = section;
    }


    public <T extends Object> T g(T t, String ...args){
        return (T) section.get(parse(args), t);
    }

    public Boolean has(String ...args){
        try{
            return section.contains(parse(args));
        }catch (Exception e){
            return false;
        }
    }

    private String parse(String ...args){
        String str = String.join(".", args);
        if(!str.equals("")){
            str = "."+ str;
        }
        return key+str;
    }
}
