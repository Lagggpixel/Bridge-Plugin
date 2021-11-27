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
        final String inGame = "false";
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Name", (Object)("" + name));
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".InGame", (Object)("" + inGame));
        PlayerConfig.PlayerConfigGet().addDefault("Player." + uuid + ".Coins", (Object)0);
        PlayerConfig.PlayerConfigSave();
    }
}
