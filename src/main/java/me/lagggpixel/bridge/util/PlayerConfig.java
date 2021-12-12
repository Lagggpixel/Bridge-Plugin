package me.lagggpixel.bridge.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    public static FileConfiguration PlayerConfigConfiguration;
    static File PlayerConfigFile;

    public static void SetupPlayerConfig() {
        PlayerConfig.PlayerConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Bridge").getDataFolder(), "PlayerConfigFile.yml");
        if (!PlayerConfig.PlayerConfigFile.exists()) {
            try {
                PlayerConfig.PlayerConfigFile.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        PlayerConfig.PlayerConfigConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(PlayerConfig.PlayerConfigFile);
    }

    public static FileConfiguration PlayerConfigGet() {
        return PlayerConfig.PlayerConfigConfiguration;
    }

    public static void PlayerConfigSave() {
        try {
            PlayerConfig.PlayerConfigConfiguration.save(PlayerConfig.PlayerConfigFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void PlayerConfigReload() {
        PlayerConfig.PlayerConfigConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(PlayerConfig.PlayerConfigFile);
    }
}
