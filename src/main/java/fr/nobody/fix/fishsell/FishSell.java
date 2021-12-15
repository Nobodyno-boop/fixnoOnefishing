package fr.nobody.fix.fishsell;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FishSell extends JavaPlugin {
    private static FishSell instance;
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private RemoteConfig remoteConfig;

    @Override
    public void onEnable() {
        // Basic vault hook.
        instance = this;
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        //check if the plugin is enabled.
        Plugin pl = Bukkit.getPluginManager().getPlugin("NoOneFishing");
        if(pl != null && pl.isEnabled()){
            remoteConfig = new RemoteConfig();
            this.getCommand("fishsell").setExecutor(new FishSells());
            Bukkit.getServer().getPluginManager().registerEvents(new CmdProcess(), this);
            new Updater(this);
        } else {
            log.severe(String.format("[%s] - Disabled due to no NoOneFishing dependency found!", getDescription().getName()));
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static FishSell getInstance() {
        return instance;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public RemoteConfig getRemoteConfig() {
        return remoteConfig;
    }

    public static Economy getEcon() {
        return econ;
    }
}
