package fr.nobody.fix.fishsell;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

// Get update from build.yml
public class Updater {
    private FileConfiguration config;
    private boolean work = true;
    private boolean hasUpdate = false;
    public Updater(Plugin plugin)  {
        try{
            URL url = new URL("https://github.com/Nobodyno-boop/fixnoOnefishing/releases/download/latest/build.yml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            config = YamlConfiguration.loadConfiguration(reader);

            if(!plugin.getDescription().getVersion().equalsIgnoreCase(config.getString("version", plugin.getDescription().getVersion()))){
                hasUpdate = true;
                FishSell.getInstance().getLogger().warning("Please update the plugin !");
                FishSell.getInstance().getLogger().warning("This plugin is an Fix plugin for NoOneFishing v1.2.0");
                FishSell.getInstance().getLogger().warning("Download the latest update at : https://github.com/Nobodyno-boop/fixnoOnefishing/releases/tag/latest");
            }
        }catch (Exception e){
            work = false;
        }


    }

}
