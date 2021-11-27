package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.*;
import org.bukkit.event.block.*;
import org.bukkit.event.*;

public class BlockBreak implements Listener
{
    Bridge plugin;

    public BlockBreak(final Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BlockBreak(final BlockBreakEvent event) {
    }
}
