package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {
    Bridge _plugin;

    public DropListener(Bridge pPlugin) {
        _plugin = pPlugin;
    }

    @EventHandler
    public void DropEvent(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }
}
