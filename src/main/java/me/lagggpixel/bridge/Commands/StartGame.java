package me.lagggpixel.bridge.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.lagggpixel.bridge.Manger.*;

public class StartGame implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length == 3) {
                final String map = args[2];
                if (command.getName().equalsIgnoreCase("start") || command.getName().equalsIgnoreCase("s")) {
                    final Player player2 = Bukkit.getServer().getPlayer(args[0]);
                    final Player player3 = Bukkit.getServer().getPlayer(args[1]);
                    player.sendMessage("Checkpoint 1");
                    GameManager.startGame(player2, player3, map, player);
                }
            }
        }
        return true;
    }
}
