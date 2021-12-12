package me.lagggpixel.bridge.Manger;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.util.GameConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static me.lagggpixel.bridge.Manger.GameManager.GameWorld;

public class WorldManager implements Listener {
    private static final Bridge plugin = Bridge.getPlugin(Bridge.class);

    static MultiverseCore core;
    static MVWorldManager worldManager;

    static Location BlueSpawn = new Location(GameWorld, -30.5, 101.0, 0.5, -90.0f, 0.0f);
    static Location RedSpawn = new Location(GameWorld, 30.5, 101.0, 0.5, -90.0f, 0.0f);

    public static void teleportPreGame(Player playerOne, Player playerTwo, World world) {
        playerOne.teleport(new Location(world, -30.5, 101.0, 0.5, -90.0f, 0.0f));
        playerTwo.teleport(new Location(world, -30.5, 101.0, 0.5, -90.0f, 0.0f));
    }

    public static World generateGameWorld(World map) {
        World world = null;
        if (map.getName().equalsIgnoreCase("urban")) {
            int urbanGenBefore = GameConfig.GameConfigGet().getInt("Map.Urban");
            int urbanGen = urbanGenBefore + 1;
            final String worldName = "urban" + urbanGen;
            try {
                copyWorld("urban", "" + worldName);
                GameConfig.GameConfigGet().set("Map.Urban", urbanGen);
                GameConfig.GameConfigSave();
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage("Error cloning world");
            }
            world = Bukkit.getWorld(worldName);
        } else if (map.getName().equalsIgnoreCase("aquatica")) {
            int aquaticaGenBefore = GameConfig.GameConfigGet().getInt("Map.Aquatica");
            int aquaticaGen = aquaticaGenBefore + 1;
            final String worldName = "aquatica" + aquaticaGen;
            try {
                copyWorld("urban", "" + worldName);
                GameConfig.GameConfigGet().set("Map.Aquatica", aquaticaGen);
                GameConfig.GameConfigSave();
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage("Error cloning world");
            }
            world = Bukkit.getWorld(worldName);
        } else {
            Bukkit.getConsoleSender().sendMessage("Error understanding map selected");
        }
        return world;
    }

    public static void copyWorld(final String pOldWorld, final String pNewWorld) {
        WorldManager.worldManager.cloneWorld(pOldWorld, pNewWorld);
    }

    public static World GenerateMap() {
        World map = null;
        int number = 0;
        int min = 0;
        int max = 3;
        number = (int)Math.floor(Math.random()*(max-min+1)+min);
        if (number == 1) {
            map = Bukkit.getWorld("urban");
        } else if (number == 2) {
            map = Bukkit.getWorld("aquatica");
        }
        return map;
    }

    public static World GetWorld(String WorldString) {
        return Bukkit.getWorld(WorldString);
    }
}
