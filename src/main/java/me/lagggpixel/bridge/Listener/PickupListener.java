package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;

public class PickupListener implements Listener {
    Bridge _plugin;

    public PickupListener(Bridge pPlugin) {
        _plugin = pPlugin;
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        if (event.getItem().getItemStack().getType() == Material.ARROW) {
            Player player = event.getPlayer();
            Inventory playerInv = player.getInventory();

            if (playerInv.contains(Material.ARROW, 1) || _plugin.get_BowCountdownManager().hasPlayerCoolDown(player)){
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(true);
        }
    }
}
