package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    Bridge plugin;

    public PlayerLeave(final Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoinEvent(final PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".Online", "false");
        PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".PreGame", "false");
        PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".InGame", "false");
        PlayerConfig.PlayerConfigSave();

        Bridge._PlayersOnline.remove(event.getPlayer());
    }
}
