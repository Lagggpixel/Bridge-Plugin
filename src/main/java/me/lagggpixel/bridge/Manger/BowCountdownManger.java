package me.lagggpixel.bridge.Manger;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BowCountdownManger implements Listener {

    private final Map<UUID, Integer> _coolDownMap = new HashMap<>();

    public BowCountdownManger(Bridge pPlugin) {
        new BukkitRunnable() {

            @Override
            public void run() {
                for (UUID uuid : _coolDownMap.keySet()) {
                    if (_coolDownMap.get(uuid) == 1) {
                        Inventory inventory = Bukkit.getPlayer(uuid).getInventory();

                        if (inventory.getItem(8) == null) {
                            inventory.setItem(8, new ItemStack(Material.ARROW));
                        } else {
                            if (inventory.getItem(8).getAmount() == 0)
                                inventory.setItem(8, new ItemStack(Material.ARROW));
                        }

                        _coolDownMap.remove(uuid);
                        continue;
                    }

                    _coolDownMap.put(uuid, _coolDownMap.get(uuid) - 1);
                }
            }
        }.runTaskTimer(pPlugin, 0, 10);
    }

    public void addPlayerCoolDown(Player pPlayer, Integer pTime) {
        _coolDownMap.put(pPlayer.getUniqueId(), pTime);
    }

    public boolean hasPlayerCoolDown(Player pPlayer) {
        return _coolDownMap.containsKey(pPlayer.getUniqueId());
    }

}
