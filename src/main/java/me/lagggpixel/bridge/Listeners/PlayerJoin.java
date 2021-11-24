package me.lagggpixel.bridge.Listeners;

import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    Bridge plugin;

    public PlayerJoin(Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String uuid = player.getUniqueId().toString();
        String name = player.getName();
        String inGame = "false";

        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Name", "" + name);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".InGame", "" + inGame);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Coins", 0);
        PlayerConfig.PlayerConfigSave();
    }
}
