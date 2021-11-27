package me.lagggpixel.bridge.Listeners;

import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    Bridge plugin;

    public BlockBreak(Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent event) {

    }
}

