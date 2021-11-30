package me.lagggpixel.bridge.Commands;

import me.lagggpixel.bridge.Manger.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Play implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (command.getName().equalsIgnoreCase("play")) {
                GameManager.PreGame(player);
            }
        }
        return true;
    }
}
