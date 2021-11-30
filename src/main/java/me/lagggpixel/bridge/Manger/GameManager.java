package me.lagggpixel.bridge.Manger;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.util.GameConfig;
import me.lagggpixel.bridge.util.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class GameManager {
    static MultiverseCore core;
    static MVWorldManager worldManager;

    static {
        GameManager.core = Bridge.getCore();
        GameManager.worldManager = GameManager.core.getMVWorldManager();
    }

    // PreGame Lobby
    public static void PreGame(final Player player) {
        String maps = "urban";
        String uuid = player.getUniqueId().toString();
        if (PlayerConfig.PlayerConfigGet().get("Player." + uuid + ".PreGame").equals("false")) {

            if (PlayerConfig.PlayerConfigGet().get("Player." + uuid + ".InGame").equals("false")) {

                if (maps.equalsIgnoreCase("urban")) {
                    int urban_before = GameConfig.GameConfigGet().getInt("Map.Urban");
                    final String worldName = "urban" + urban_before;
                    try {
                        copyWorld("urban", "" + worldName);
                    } catch (Exception e) {
                        Bukkit.getConsoleSender().sendMessage("Error cloning world");
                    }
                    final MVWorld map = (MVWorld) GameManager.worldManager.getMVWorld(worldName);
                    final World GameWorld = map.getCBWorld();
                    GameManager.core.loadConfigs();
                    GameManager.TeleportPreGame(GameWorld, player, "urban", urban_before);
                    int urban_after = urban_before + 1;
                    GameConfig.GameConfigGet().set("Urban.Map", urban_after);
                    PlayerConfig.PlayerConfigGet().set("Player." + uuid + ".PreGame", "true");
                    PlayerConfig.PlayerConfigSave();
                }

            } else {
                player.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "You are in a game at the moment. If you believe this is an error, contact your server admin.");
            }
        } else {
            player.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "You are already queuing at the moment. If you believe this is an error, contact your server admin.");
        }
    }

    public static void copyWorld(final String pOldWorld, final String pNewWorld) {
        GameManager.worldManager.cloneWorld(pOldWorld, pNewWorld);
    }

    public static void TeleportPreGame(World GameWorld, Player player, String MapName, int MapNumber) {
        try {
            final Location loc1 = new Location(GameWorld, -30.5, 101.0, 0.5, -90.0f, 0.0f);
            player.teleport(loc1);
        }
        catch (Exception e2) {
            player.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "There has been an issue loading in the game, if this continuously occurs, please contact a server administer");
        }
    }

    // Start Game
    public static void TeleportStartGame(World GameWorld, Player player1, Player player2, Player sender, String MapName, int MapNumber) {
        try {
            final Location loc1 = new Location(GameWorld, -30.5, 101.0, 0.5, -90.0f, 0.0f);
            player1.teleport(loc1);
            final Location loc2 = new Location(GameWorld, 30.5, 101.0, 0.5, -90.0f, 0.0f);
            player2.teleport(loc2);
            final Location loc3 = new Location(GameWorld, 0.5, 93.0, 0.5, 0.0f, 0.0f);
            sender.teleport(loc3);
            AddGame(MapName, MapNumber, player1, player2);
        }
        catch (Exception e2) {
            sender.sendMessage(ChatColor.YELLOW + "Bridge >>> " + ChatColor.RED + "There has been an issue loading in the game, if this continuously occurs, please contact a server administer");
        }
    }

    //In Game

    //End Game

    //ConfigFile
    public static void AddGame(String MapName, int MapNumber, Player BlueTeam, Player RedTeam) {
        GameConfig.GameConfigGet().addDefault(MapName + "." + MapNumber + ".Players.Blue", "" + BlueTeam.getName());
        GameConfig.GameConfigGet().addDefault(MapName + "." + MapNumber + ".Players.Red", "" + RedTeam.getName());
        GameConfig.GameConfigGet().addDefault(MapName + "." + MapNumber + ".Goals.Red", 0);
        GameConfig.GameConfigGet().addDefault(MapName + "." + MapNumber + ".Goals.Blue", 0);
        GameConfig.GameConfigGet().addDefault(MapName + "." + MapNumber + ".GameEnd", "false");
        GameConfig.GameConfigGet().addDefault(MapName + "." + MapNumber + ".GameTime", 0);
    }
}
