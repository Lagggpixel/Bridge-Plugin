package me.lagggpixel.bridge.PlayerData;

import me.lagggpixel.bridge.Bridge;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoin extends JavaPlugin implements Listener {

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

        PlayerConfig.PlayerConfigGet().addDefault("Name", name);
        PlayerConfig.PlayerConfigGet().addDefault("InGame", inGame);
        PlayerConfig.PlayerConfigGet().addDefault("Coins", 0);
    }
}
