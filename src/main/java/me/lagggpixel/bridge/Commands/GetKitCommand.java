package me.lagggpixel.bridge.Commands;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetKitCommand implements CommandExecutor {

    Bridge _plugin;

    public GetKitCommand(Bridge pPlugin) {
        _plugin = pPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            _plugin.getItemManager().giveKit(player, "Blue");
        }

        return true;
    }
}
