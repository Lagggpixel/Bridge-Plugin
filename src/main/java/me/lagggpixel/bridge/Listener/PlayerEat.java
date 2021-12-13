package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEat implements Listener {
    Bridge _plugin;

    public PlayerEat(Bridge pPlugin) {
        _plugin = pPlugin;
    }

    @EventHandler
    public void PlayerEatEvent(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() == Material.GOLDEN_APPLE) {
            Player player = event.getPlayer();
            player.sendMessage("eaten golden apple");
            double health = player.getMaxHealth();
            player.setHealth(health);
            event.setCancelled(true);
            Material golden_apple = Material.GOLDEN_APPLE;

            for (ItemStack item : player.getInventory()) {
                if (item.getType() == golden_apple) {
                    item.setAmount(item.getAmount() - 1);
                }
            }
        }
    }
}
