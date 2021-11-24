package me.lagggpixel.bridge.PlayerData;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class PlayerManger {
    private UUID _uuid;
    private boolean _inGame;
    private int _coinsEarned;
    private boolean _isSpec;

    public PlayerManger(UUID pUuid, boolean pInGame, int pCoinsEarned, boolean pIsSpec){
        this._uuid = pUuid;
        this._inGame = pInGame;
        this._coinsEarned = pCoinsEarned;
        this._isSpec = pIsSpec;
    }

    public UUID get_uuid() {
        return _uuid;
    }

    public void set_uuid(UUID pUuid) {
        this._uuid = pUuid;
    }

    public boolean is_inGame() {
        return _inGame;
    }

    public void set_inGame(boolean pInGame) {
        this._inGame = pInGame;
    }

    public int get_coinsEarned() {
        return _coinsEarned;
    }

    public void set_coinsEarned(int pCoinsEarned) {
        this._coinsEarned = pCoinsEarned;
    }

    public boolean is_isSpec() {
        return _isSpec;
    }

    public void set_isSpec(boolean pIsSpec) {
        this._isSpec = pIsSpec;
    }
}
