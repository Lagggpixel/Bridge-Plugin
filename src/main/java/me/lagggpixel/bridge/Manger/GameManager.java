package me.lagggpixel.bridge.Manger;

import com.onarandombox.MultiverseCore.MultiverseCore;
import me.lagggpixel.bridge.Bridge;
import me.lagggpixel.bridge.Packets.SendTitle;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GameManager implements Listener {
    private static final Bridge plugin = Bridge.getPlugin(Bridge.class);
    private static final int PreGameTotalTime = 5;
    private final int IntervalTotalTime = 3;
    private final int InGameTotalTime = 900;
    private final int PlayerNeeded = 2;
    private boolean IsStarted;

    static MultiverseCore core;

    static World GameWorld;

    public static void Duel(Player player1, Player player2, Player sender, String Spec) {
        try {
            GameWorld = WorldManager.generateGameWorld(WorldManager.GenerateMap());
            WorldManager.teleportPreGame(player1, player2, GameWorld);
        } catch (Exception ignored) {}
        ArrayList<Player> p;
        p = new ArrayList<>();
        p.add(player1);
        p.add(player2);
        PreGameCountDown(p);
    }

    public static void PreGameLobby(Player player) {
        String GameWorld = null;
        int InGame = Bukkit.getWorld(GameWorld).getPlayers().size();
    }

    public static void TeleportPlayers(Player player) {}

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

    public static void GameStart(String Game) {}

    public static void GameStop(String Game) {}

    public void GameCountDown() {
        new BukkitRunnable() {
            @Override
            public void run() {
                int GameCountDown = InGameTotalTime;
                while (GameCountDown > 0) {
                    GameCountDown--;
                }
            }

        }.runTaskTimerAsynchronously(plugin, 0, 20L);
    }

    public static void PreGameCountDown(ArrayList<Player> players) {
        String message = "Game starts in: ";
        new BukkitRunnable() {
            @Override
            public void run() {
                int PreGameCountDown = PreGameTotalTime;
                while (PreGameCountDown > 0) {
                    for (int i = 0; i < players.toArray().length; i++) {
                        Player player = players.get(i);
                        SendTitle.SendPlayer(player, message + PreGameCountDown);
                    }
                    PreGameCountDown--;

                }
                //GameStart();
            }
        }.runTaskTimerAsynchronously(plugin, 0, 20L);
    }
}