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
        GameConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Bridge").getDataFolder(), "GameConfigFile.yml");

        if (!GameConfigFile.exists()) {
            try {
                GameConfigFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        GameConfigConfiguration = YamlConfiguration.loadConfiguration(GameConfigFile);
    }

    public static FileConfiguration GameConfigGet() {
        return GameConfigConfiguration;
    }

    public static void GameConfigSave() {
        try {
            GameConfigConfiguration.save(GameConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GameConfigReload() {
        GameConfigConfiguration = YamlConfiguration.loadConfiguration(GameConfigFile);
    }

    public void GameMapConfigSetup() {
        GameConfig.GameConfigGet().addDefault("map.urban", 0);
    }
}