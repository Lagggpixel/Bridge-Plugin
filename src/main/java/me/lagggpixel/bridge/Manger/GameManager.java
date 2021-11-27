package me.lagggpixel.bridge.Manger;

import com.onarandombox.MultiverseCore.api.*;
import org.bukkit.entity.*;
import com.onarandombox.MultiverseCore.*;
import org.bukkit.*;
import me.lagggpixel.bridge.*;

public class GameManager {
    static MultiverseCore core;
    static MVWorldManager worldManager;

    public static void startGame(final Player player1, final Player player2, final String maps, final Player sender) {
        sender.sendMessage("before map check");
        if (maps.equalsIgnoreCase("urban")) {
            final int urban = 1;
            final String worldName = "urban" + urban;
            try {
                copyWorld("urban", "" + worldName);
            }
            catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage("Error cloning world");
            }
            final MVWorld map = (MVWorld)GameManager.worldManager.getMVWorld(worldName);
            final World GameWorld = map.getCBWorld();
            GameManager.core.loadConfigs();
            try {
                final Location loc1 = new Location(GameWorld, -30.5, 101.0, 0.5, -90.0f, 0.0f);
                player1.teleport(loc1);
            }
            catch (Exception e2) {
                Bukkit.getServer().getConsoleSender().sendMessage("There has been an error teleporting " + player1.getName() + "to a bridge world.");
            }
            try {
                final Location loc2 = new Location(GameWorld, 30.5, 101.0, 0.5, -90.0f, 0.0f);
                player2.teleport(loc2);
            }
            catch (Exception e2) {
                Bukkit.getServer().getConsoleSender().sendMessage("There has been an error teleporting " + player2.getName() + "to a bridge world.");
            }
            try {
                final Location loc3 = new Location(GameWorld, 0.5, 93.0, 0.5, 0.0f, 0.0f);
                sender.teleport(loc3);
            }
            catch (Exception e2) {
                Bukkit.getServer().getConsoleSender().sendMessage("There has been an error teleporting " + sender.getName() + "to a bridge world.");
            }
        }
    }

    public static void copyWorld(final String pOldWorld, final String pNewWorld) {
        GameManager.worldManager.cloneWorld(pOldWorld, pNewWorld);
    }

    static {
        GameManager.core = Bridge.getCore();
        GameManager.worldManager = GameManager.core.getMVWorldManager();
    }
}
