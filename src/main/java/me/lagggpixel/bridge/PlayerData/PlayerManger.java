package me.lagggpixel.bridge.PlayerData;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class PlayerManger {
    private UUID uuid;
    private boolean inGame;
    private int coinsEarned;
    private boolean isSpec;

    public PlayerManger(UUID uuid, boolean ingame, int coinsearned, boolean isdead){
        this.setUuid(uuid);
        this.setInGame(ingame);
        this.setCoinsEarned(coinsearned);
        this.setSpec(isSpec);
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isInGame() {
        return inGame;
    }

    public int getCoinsEarned() {
        return coinsEarned;
    }

    public boolean isSpec() {
        return isSpec;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setCoinsEarned(int coinsEarned) {
        this.coinsEarned = coinsEarned;
    }

    public void setSpec(boolean spec) {
        isSpec = spec;
    }
}
