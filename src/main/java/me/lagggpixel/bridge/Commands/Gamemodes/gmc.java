package me.lagggpixel.bridge.Commands.Gamemodes;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.hasPermission("Admin.Gamemode")){
                player.setGameMode(GameMode.CREATIVE);
                }
             else {
                 player.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "You don not have the permission to do this.");
            }
        }

        return true;
    }
}
