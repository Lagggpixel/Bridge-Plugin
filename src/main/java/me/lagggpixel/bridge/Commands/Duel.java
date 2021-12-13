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
                Player player1 = Bukkit.getPlayer(strings[0]);
                Player player2 = Bukkit.getPlayer(strings[1]);
                GameManager.Duel(player1, player2);
            } else {
                sender.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "Insufficient arguments.");
            }
        } else {
            if (strings.length == 2) {
                Player player1 = Bukkit.getPlayer(strings[0]);
                Player player2 = Bukkit.getPlayer(strings[1]);
                GameManager.Duel(player1, player2);
            } else {
                System.out.println("Bridge >>> Insufficient arguments.");
            }
        }
        return true;
    }

}
