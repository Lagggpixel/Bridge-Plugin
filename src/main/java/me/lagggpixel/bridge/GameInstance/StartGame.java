package me.lagggpixel.bridge.GameInstance;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class StartGame implements Listener {
    MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

    MVWorldManager worldManager = core.getMVWorldManager();

    worldManager.cloneWorld(String oldName, String newName);

    public static void start() {

    }

}
