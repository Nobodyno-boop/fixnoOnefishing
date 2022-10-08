package fr.nobody.fix.fishsell.command;

import fr.nobody.fix.fishsell.FishSell;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FishSells implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("fishsell") && FishSell.getInstance().getConfig().getBoolean("fix.command.custom", false)){
            if (sender instanceof Player || sender.hasPermission("") || sender.isOp()) {
                Player p = (Player) sender;
                FishSell.getInstance().getRemoteConfig().sellfish(p);
            }
        }
        return true;
    }
}
