package me.lagggpixel.bridge;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.lagggpixel.bridge.Commands.startGame;
import me.lagggpixel.bridge.Listeners.PlayerJoin;
import me.lagggpixel.bridge.Manger.PlayerManager;
import me.lagggpixel.bridge.util.GameConfig;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public final class Bridge extends JavaPlugin {

    private ArrayList<PlayerManager> _playerManager = new ArrayList<PlayerManager>();
    private Bridge _plugin;
    private static MultiverseCore _core;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Thank you for using bridge, the plugin has been enabled.");

        register();
        setupConfig();
        setupMultiverse();
        setupCommands();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Thank you for using bridge, the plugin has been disabled.");
    }

    private void register() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    private void setupConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        PlayerConfig.SetupPlayerConfig();
        PlayerConfig.PlayerConfigGet().options().copyDefaults(true);
        PlayerConfig.PlayerConfigSave();

        GameConfig.SetupGameConfig();
        GameConfig.GameConfigGet().options().copyDefaults(true);
        GameConfig.GameConfigSave();
    }

    private void setupCommands() {
        this.getCommand("start").setExecutor(new startGame());
    }

    private void setupMultiverse() {
        _core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
    }

    public Bridge getPlugin() {
        return _plugin;
    }

    public static MultiverseCore getCore() {
        return _core;
    }

    public ArrayList<PlayerManager> getPlayerManager() {
        return _playerManager;
    }

    public void setPlayerManager(ArrayList<PlayerManager> pPlayerManager) {
        this._playerManager = pPlayerManager;
    }

}
