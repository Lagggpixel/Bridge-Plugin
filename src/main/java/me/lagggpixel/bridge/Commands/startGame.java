package me.lagggpixel.bridge.Commands;

import me.lagggpixel.bridge.Manger.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class startGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 3) {
                String map = args[2];
                if ((command.getName().equalsIgnoreCase("start")) || (command.getName().equalsIgnoreCase("s"))) {
                    Player player1 = getServer().getPlayer(args[0]);
                    Player player2 = getServer().getPlayer(args[1]);
                    player.sendMessage("Checkpoint 1");
                    GameManager.startGame(player1, player2, map, player);
                }
            }
        }
        return true;
    }
}
