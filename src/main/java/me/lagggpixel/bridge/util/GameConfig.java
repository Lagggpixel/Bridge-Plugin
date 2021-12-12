package me.lagggpixel.bridge.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class GameConfig {
    static File GameConfigFile;
    public static FileConfiguration GameConfigConfiguration;

    public static void SetupGameConfig() {
        GameConfig.GameConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Bridge").getDataFolder(), "GameConfigFile.yml");
        if (!GameConfig.GameConfigFile.exists()) {
            try {
                GameConfig.GameConfigFile.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        GameConfig.GameConfigConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(GameConfig.GameConfigFile);
        GameConfig.addDefaults();
    }

    public static FileConfiguration GameConfigGet() {
        return GameConfig.GameConfigConfiguration;
    }

    public static void GameConfigSave() {
        try {
            GameConfig.GameConfigConfiguration.save(GameConfig.GameConfigFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GameConfigReload() {
        GameConfig.GameConfigConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(GameConfig.GameConfigFile);
    }

    public static void addDefaults() {
        GameConfigGet().addDefault("Map.Urban", (Object)0);
        GameConfigGet().addDefault("Map.Aquatica", (Object)0);
    }

}
