package fr.nobody.fix.fishsell.command;

import fr.nobody.fix.fishsell.FishSell;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class FishReload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("fishsell.reload") || sender.isOp()) {
            FishSell.getInstance().reloadConfig();
            sender.sendMessage("[FishSell] Reload config");
        }
        return false;
    }
}
