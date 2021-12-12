package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.Manger.PlayerManager;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener
{
    Bridge plugin;

    public PlayerJoin(final Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        String uuid_toString = player.getUniqueId().toString();
        String name = player.getName();
        String InGame = "false";
        String PreGame = "false";
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid_toString + ".Name", "" + name);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid_toString + ".InGame", "" + InGame);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid_toString + ".PreGame", "" + PreGame);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid_toString + ".Coins", 0);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid_toString + ".Online", "true");
        PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".Online", "true");
        PlayerConfig.PlayerConfigSave();

        plugin._PlayersOnline.add(event.getPlayer());

        plugin.get_scoreboards().createNewScoreboard(player);

        plugin._playerManager.put(uuid, new PlayerManager(uuid, false, 0, false));
    }
}
