package me.lagggpixel.bridge.Commands;

import me.lagggpixel.bridge.Manger.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Duel implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player sender = (Player) commandSender;

            if (strings.length == 2) {
                try {
                    Player player1 = Bukkit.getPlayer(strings[0]);
                    Player player2 = Bukkit.getPlayer(strings[1]);
                    GameManager.Duel(player1, player2, sender, "false");
                } catch (Exception ignored) {}
            } else if (strings.length == 3) {
                try {
                    Player player1 = Bukkit.getPlayer(strings[0]);
                    Player player2 = Bukkit.getPlayer(strings[1]);
                    GameManager.Duel(player1, player2, sender, strings[2]);
                } catch (Exception ignored) {}
            } else {
                sender.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "Insufficient arguments, contact a server admin if you believe this is an error.");
            }
        } else {
            if (strings.length == 2) {
                try {
                    Player player1 = Bukkit.getPlayer(strings[0]);
                    Player player2 = Bukkit.getPlayer(strings[1]);
                    GameManager.Duel(player1, player2, Bukkit.getPlayer("Lagggpixel"), "false");
                } catch (Throwable ignored) {
                }
            } else {
                System.out.println("Error, please check if the plugin is updated.");
            }
        }
        return true;
    }

}
