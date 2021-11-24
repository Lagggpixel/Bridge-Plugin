package me.lagggpixel.bridge.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class PlayerConfig extends JavaPlugin {
    static File PlayerConfigFile;
    public static FileConfiguration PlayerConfigConfiguration;

    public static void SetupPlayerConfig() {
        PlayerConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Bridge").getDataFolder(), "PlayerConfigFile.yml");

        if (!PlayerConfigFile.exists()) {
            try {
                PlayerConfigFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PlayerConfigConfiguration = YamlConfiguration.loadConfiguration(PlayerConfigFile);
    }

    public static FileConfiguration PlayerConfigGet() {
        return PlayerConfigConfiguration;
    }

    public static void PlayerConfigSave() {
        try {
            PlayerConfigConfiguration.save(PlayerConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void PlayerConfigReload() {
        PlayerConfigConfiguration = YamlConfiguration.loadConfiguration(PlayerConfigFile);
    }
}
