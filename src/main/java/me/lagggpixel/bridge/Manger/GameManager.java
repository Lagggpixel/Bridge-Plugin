package me.lagggpixel.bridge.Manger;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import me.lagggpixel.bridge.Bridge;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getConsoleSender;
import static org.bukkit.Bukkit.getServer;

public class GameManager{
    static MultiverseCore core = Bridge.getCore();
    static MVWorldManager worldManager = core.getMVWorldManager();

    public static void startGame(Player player1, Player player2, String maps, Player sender) {
        sender.sendMessage("before map check");
        //map check
        if (maps.equalsIgnoreCase("urban")) {
            int urban = 1;//(int) GameConfig.GameConfigGet().get("Map.Urban")
            String worldName = "urban" + urban;
            try {
                copyWorld("urban", "" + worldName);
            } catch (Exception e) {
                getConsoleSender().sendMessage("Error cloning world");
            }
            MVWorld map = (MVWorld) worldManager.getMVWorld(worldName);
            World GameWorld = map.getCBWorld();
            core.loadConfigs();
            // Teleporting players into the game
            try {
                Location loc1 = new Location(GameWorld, -30.5, 101, 0.5, -90, 0);
                player1.teleport(loc1);

            }catch (Exception e) {
                getServer().getConsoleSender().sendMessage("There has been an error teleporting " + player1.getName() + "to a bridge world.");
            }
            try {
                Location loc2 = new Location(GameWorld, 30.5, 101, 0.5, -90, 0);
                player2.teleport(loc2);
            } catch (Exception e) {
                getServer().getConsoleSender().sendMessage("There has been an error teleporting " + player2.getName() + "to a bridge world.");
            }

            try {
                Location loc3 = new Location(GameWorld, 0.5, 93, 0.5, 0, 0);
                sender.teleport(loc3);
            } catch (Exception e) {
                getServer().getConsoleSender().sendMessage("There has been an error teleporting " + sender.getName() + "to a bridge world.");
            }
        }
    }

    public static void copyWorld(String pOldWorld, String pNewWorld) {
        worldManager.cloneWorld(pOldWorld, pNewWorld);
    }
}
