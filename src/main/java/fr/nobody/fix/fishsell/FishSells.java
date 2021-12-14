package fr.nobody.fix.fishsell;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FishSells implements CommandExecutor {





    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("fishsell")){
            if(sender instanceof Player && sender.isOp()){
                Player p = (Player) sender;
                FishSell.getInstance().getRemoteConfig().sellfish(p);
            }
        }
        return true;
    }
}
