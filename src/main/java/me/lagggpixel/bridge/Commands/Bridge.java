package me.lagggpixel.bridge.Commands;

import me.lagggpixel.bridge.util.GameConfig;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Bridge implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    GameConfig.GameConfigReload();
                    PlayerConfig.PlayerConfigReload();

                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "Plugin has been successfully reloaded");
                    }
                        getServer().getConsoleSender().sendMessage("[Bridge] Plugin has been successfully reloaded");
                }

                if (args[0].equalsIgnoreCase("help")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage(ChatColor.YELLOW + "Bridge >>> Help");
                        player.sendMessage(ChatColor.YELLOW + "/bridge help: Show this menu.");
                        if (player.hasPermission("Bridge.Reload")) {
                            player.sendMessage(ChatColor.RED + "/bridge reload: Reload this plugin and it's config files.");
                        }

                    }
                }
            }

        } catch (Exception e){
            getServer().getConsoleSender().sendMessage("There has been an error reloading the bridge plugin, this is caused by" + e);
        }

        return true;
    }
}
