package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener
{
    Bridge plugin;

    public BlockBreak(final Bridge plugin) {
        this.plugin = plugin;
    }

    String message = ChatColor.RED + "You can't break that block.";

    @EventHandler
    public void BlockBreakEvent(final BlockBreakEvent event) {
        Block block  = event.getBlock();
        Player player = event.getPlayer();
        if (block.getType() != Material.STAINED_CLAY) {
            event.setCancelled(true);
            player.sendMessage(message);
        } else {
            if (!(block.getData() == DyeColor.RED.getWoolData() || block.getData() == DyeColor.BLUE.getWoolData()
                    || block.getData() == DyeColor.WHITE.getWoolData())) {
                event.setCancelled(true);
                player.sendMessage(message);
            }
        }
        if (block.getY() > 99) {
            event.setCancelled(true);
            player.sendMessage(message);
        }
    }
}
