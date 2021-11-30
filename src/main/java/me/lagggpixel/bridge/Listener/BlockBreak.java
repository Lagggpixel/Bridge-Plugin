package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener
{
    Bridge plugin;

    public BlockBreak(final Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BlockBreakEvent(final BlockBreakEvent event) {
        Block block  = event.getBlock();

        if (block.getType() != Material.STAINED_CLAY || block.getY() > 100) {
            event.setCancelled(true);
        } else {
            if (!(block.getData() == DyeColor.RED.getWoolData() || block.getData() == DyeColor.BLUE.getWoolData()
                    || block.getData() == DyeColor.WHITE.getWoolData())) {
                event.setCancelled(true);
            }
        }
    }
}
