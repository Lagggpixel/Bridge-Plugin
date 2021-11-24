package me.lagggpixel.bridge;

import me.lagggpixel.bridge.PlayerData.PlayerConfig;
import me.lagggpixel.bridge.PlayerData.PlayerJoin;
import me.lagggpixel.bridge.PlayerData.PlayerManger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public final class Bridge extends JavaPlugin {

    public ArrayList<PlayerManger> playerManager = new ArrayList<PlayerManger>();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Thank you for using bridge, the plugin has been enabled.");

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        PlayerConfig.SetupPlayerConfig();
        PlayerConfig.PlayerConfigGet().options().copyDefaults(true);
        PlayerConfig.PlayerConfigSave();


        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Thank you for using bridge, the plugin has been disabled.");
    }
}
