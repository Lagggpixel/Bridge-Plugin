package me.lagggpixel.bridge.Manger;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import me.lagggpixel.bridge.Bridge;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GameManager implements Listener{
    MultiverseCore core = Bridge.getCore();

    MVWorldManager worldManager = core.getMVWorldManager();

    public void startGame(Player player1, Player player2) {

    }

    private void copyWorld(String pOldWorld, String pNewWorld) {
        worldManager.cloneWorld(pOldWorld, pNewWorld);
    }

}
