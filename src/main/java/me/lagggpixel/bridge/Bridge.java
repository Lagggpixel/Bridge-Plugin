package me.lagggpixel.bridge;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.lagggpixel.bridge.Commands.StartGame;
import me.lagggpixel.bridge.Listener.PlayerJoin;
import me.lagggpixel.bridge.Manger.PlayerManager;
import me.lagggpixel.bridge.util.GameConfig;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Bridge extends JavaPlugin
{
    private ArrayList<PlayerManager> _playerManager;
    private Bridge _plugin;
    private static MultiverseCore _core;

    public Bridge() {
        this._playerManager = new ArrayList<PlayerManager>();
    }

    public void onEnable() {
        this.getServer().getConsoleSender().sendMessage("Thank you for using bridge, the plugin has been enabled.");
        this.register();
        this.setupConfig();
        this.setupMultiverse();
        this.setupCommands();
    }

    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage("Thank you for using bridge, the plugin has been disabled.");
    }

    private void register() {
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerJoin(this), (Plugin)this);
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
        this.getCommand("start").setExecutor((CommandExecutor)new StartGame());
    }

    private void setupMultiverse() {
        Bridge._core = (MultiverseCore)Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
    }

    public Bridge getPlugin() {
        return this._plugin;
    }

    public static MultiverseCore getCore() {
        return Bridge._core;
    }

    public ArrayList<PlayerManager> getPlayerManager() {
        return this._playerManager;
    }

    public void setPlayerManager(final ArrayList<PlayerManager> pPlayerManager) {
        this._playerManager = pPlayerManager;
    }
}
