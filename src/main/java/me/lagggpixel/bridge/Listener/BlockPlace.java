package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
    Bridge plugin;

    public BlockPlace(final Bridge plugin) {
        this.plugin = plugin;
    }

    String message = ChatColor.RED + "You can't place blocks there.";

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if (block.getY() > 99 ) {
            event.setCancelled(true);
            player.sendMessage(message);
        }
    }
}
