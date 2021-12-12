package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class BowListener implements Listener {

    Bridge _plugin;

    public BowListener(Bridge pPlugin) {
        _plugin = pPlugin;
    }

    @EventHandler
    public void OnBowShot(EntityShootBowEvent event) {
        Player player;

        if (event.getEntity() instanceof Player) {
            player = (Player) event.getEntity();

            if (_plugin.get_BowCountdownManager().hasPlayerCoolDown(player)) {
                player.sendMessage(ChatColor.DARK_RED + "You cannot use that now");
                event.setCancelled(true);
            } else {
                _plugin.get_BowCountdownManager().addPlayerCoolDown(player, 3);
            }
        }
    }
}
