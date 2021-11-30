package me.lagggpixel.bridge.Listener;

import me.lagggpixel.bridge.*;
import org.bukkit.event.player.*;
import me.lagggpixel.bridge.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerJoin implements Listener
{
    Bridge plugin;

    public PlayerJoin(final Bridge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoinEvent(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final String uuid = player.getUniqueId().toString();
        final String name = player.getName();
        final String InGame = "false";
        final String PreGame = "false";
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Name", "" + name);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".InGame", "" + InGame);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".PreGame", "" + PreGame);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Coins", 0);
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Online", "true");
        PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".Online", "true");
        PlayerConfig.PlayerConfigSave();
    }
}
