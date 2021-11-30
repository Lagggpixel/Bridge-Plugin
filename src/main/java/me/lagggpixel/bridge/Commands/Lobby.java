package me.lagggpixel.bridge.Commands;

import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lobby implements CommandExecutor {

    World spawn = Bukkit.getWorld("world");
    Location spawn_loc = new Location(spawn, 30000.5, 65, 0, 0, 0);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            String uuid = player.getUniqueId().toString();

            if (PlayerConfig.PlayerConfigGet().get("Player." + uuid + ".PreGame").equals("true")) {
                if (PlayerConfig.PlayerConfigGet().get("Player." + uuid + ".InGame").equals("true")) {

                } else {
                    player.teleport(spawn_loc);
                    PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".PreGame", "false");
                    PlayerConfig.PlayerConfigSave();
                }
            } else {
                player.teleport(spawn_loc);
            }

        } else {
            sender.sendMessage("You are not a player");
        }

        return true;
    }
}
