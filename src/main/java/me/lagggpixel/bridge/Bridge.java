package me.lagggpixel.bridge;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.lagggpixel.bridge.Commands.Duel;
import me.lagggpixel.bridge.Commands.Gamemodes.gmc;
import me.lagggpixel.bridge.Commands.Gamemodes.gms;
import me.lagggpixel.bridge.Commands.Gamemodes.gmsp;
import me.lagggpixel.bridge.Commands.GetKitCommand;
import me.lagggpixel.bridge.Listener.*;
import me.lagggpixel.bridge.Manger.BowCountdownManger;
import me.lagggpixel.bridge.Manger.ItemManager;
import me.lagggpixel.bridge.Manger.PlayerManager;
import me.lagggpixel.bridge.Manger.Scoreboards;
import me.lagggpixel.bridge.util.GameConfig;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class Bridge extends JavaPlugin
{
    public static ArrayList<Player> _PlayersOnline = new ArrayList<Player>();
    private static MultiverseCore _core;
    public HashMap<UUID, PlayerManager> _playerManager = new HashMap<UUID, PlayerManager>();
    private Bridge _plugin;
    private Scoreboards _scoreboards;
    private BowCountdownManger _BowCountdownManager;
    private ItemManager _ItemManager;

    public ItemManager getItemManager() {
        return _ItemManager;
    }

    public BowCountdownManger get_BowCountdownManager() {
        return _BowCountdownManager;
    }

    public static MultiverseCore getCore() {
        return me.lagggpixel.bridge.Bridge._core;
    }

    public Scoreboards get_scoreboards() {
        return _scoreboards;
    }

    public void onEnable() {
        this.getServer().getConsoleSender().sendMessage("[Bridge] Thank you for using bridge, the plugin has been enabled.");
        this.register();
        this.setupConfig();
        this.setupMultiverse();
        this.setupCommands();

        _scoreboards = new Scoreboards();
        _ItemManager = new ItemManager();
        _BowCountdownManager = new BowCountdownManger(this);
    }

    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage("[Bridge] Thank you for using bridge, the plugin has been disabled.");

    }

    private void register() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlace(this), this);
        this.getServer().getPluginManager().registerEvents(new BowListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PickupListener(this), this);

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
        this.getCommand("bridge").setExecutor(new me.lagggpixel.bridge.Commands.Bridge());

        this.getCommand("duel").setExecutor(new Duel());

        this.getCommand("gmc").setExecutor(new gmc());
        this.getCommand("gmsp").setExecutor(new gmsp());
        this.getCommand("gms").setExecutor(new gms());

        this.getCommand("kit").setExecutor(new GetKitCommand(this));
    }

    private void setupMultiverse() {
        me.lagggpixel.bridge.Bridge._core = (MultiverseCore)Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
    }
}
