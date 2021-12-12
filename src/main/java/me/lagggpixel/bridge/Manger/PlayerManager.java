package me.lagggpixel.bridge.Manger;

import java.util.UUID;

public class PlayerManager {
    private UUID _uuid;
    private boolean _inGame;
    private int _coinsEarned;
    private boolean _isSpec;

    public PlayerManager(UUID pUuid, boolean pInGame, int pCoinsEarned, boolean pIsSpec) {
        this._uuid = pUuid;
        this._inGame = pInGame;
        this._coinsEarned = pCoinsEarned;
        this._isSpec = pIsSpec;
    }
    
    public UUID get_uuid() {
        return this._uuid;
    }

    public void set_uuid(UUID pUuid) {
        this._uuid = pUuid;
    }

    public boolean is_inGame() {
        return this._inGame;
    }

    public void set_inGame(boolean pInGame) {
        this._inGame = pInGame;
    }

    public int get_coinsEarned() {
        return this._coinsEarned;
    }

    public void set_coinsEarned(int pCoinsEarned) {
        this._coinsEarned = pCoinsEarned;
    }

    public boolean is_isSpec() {
        return this._isSpec;
    }

    public void set_isSpec(boolean pIsSpec) {
        this._isSpec = pIsSpec;
    }
}
