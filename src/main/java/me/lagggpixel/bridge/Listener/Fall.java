package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Fall implements Listener {
    Bridge _plugin;

    public Fall(Bridge pPlugin) {
        _plugin = pPlugin;
    }

    @EventHandler
    public void FallListener(EntityDamageEvent event) {
        if ( event.getEntity() instanceof Player ) {
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
        }
    }
}
