package me.lagggpixel.bridge;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.lagggpixel.bridge.Commands.Play;
import me.lagggpixel.bridge.Listener.BlockBreak;
import me.lagggpixel.bridge.Listener.BowListener;
import me.lagggpixel.bridge.Listener.PlayerJoin;
import me.lagggpixel.bridge.Listener.PlayerLeave;
import me.lagggpixel.bridge.Manger.PlayerManager;
import me.lagggpixel.bridge.util.GameConfig;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Bridge extends JavaPlugin
{
    private ArrayList<PlayerManager> _playerManager;
    private Bridge _plugin;
    private static MultiverseCore _core;

    public void onEnable() {
        this.getServer().getConsoleSender().sendMessage("[Bridge] Thank you for using bridge, the plugin has been enabled.");
        this.register();
        this.setupConfig();
        this.setupMultiverse();
        this.setupCommands();
    }

    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage("[Bridge] Thank you for using bridge, the plugin has been disabled.");
    }

    private void register() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        this.getServer().getPluginManager().registerEvents(new BowListener(this), this);
    }

    private void setupConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        PlayerConfig.SetupPlayerConfig();
        PlayerConfig.PlayerConfigGet().options().copyDefaults(true);
        PlayerConfig.PlayerConfigSave();
        GameConfig.SetupGameConfig();
        GameConfig.GameConfigGet().options().copyDefaults(true);
        GameConfig.GameConfigSave();
    }

    private void setupCommands() {
        this.getCommand("play").setExecutor(new Play());
        this.getCommand("bridge").setExecutor(new me.lagggpixel.bridge.Commands.Bridge());
    }

    private void setupMultiverse() {
        me.lagggpixel.bridge.Bridge._core = (MultiverseCore)Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
    }

    public static MultiverseCore getCore() {
        return me.lagggpixel.bridge.Bridge._core;
    }

    public ArrayList<PlayerManager> getPlayerManager() {
        return this._playerManager;
    }

    public void setPlayerManager(final ArrayList<PlayerManager> pPlayerManager) {
        this._playerManager = pPlayerManager;
    }
}
