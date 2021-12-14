package fr.nobody.fix.fishsell;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CmdProcess implements Listener {

    @EventHandler
    public void event(PlayerCommandPreprocessEvent e){
        if(e.getMessage().equalsIgnoreCase("/nfsell inventory")){
            e.setCancelled(true);
            FishSell.getInstance().getRemoteConfig().sellfish(e.getPlayer());
        }
        if(e.getMessage().equalsIgnoreCase("/nfreload")){
            FishSell.getInstance().getRemoteConfig().reloadConfig();
        }
    }
}
