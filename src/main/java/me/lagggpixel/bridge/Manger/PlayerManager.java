package me.lagggpixel.bridge.Manger;

import java.util.*;

public class PlayerManager {
    private UUID _uuid;
    private boolean _inGame;
    private int _coinsEarned;
    private boolean _isSpec;

    public PlayerManager(final UUID pUuid, final boolean pInGame, final int pCoinsEarned, final boolean pIsSpec) {
        this._uuid = pUuid;
        this._inGame = pInGame;
        this._coinsEarned = pCoinsEarned;
        this._isSpec = pIsSpec;
    }

    public UUID get_uuid() {
        return this._uuid;
    }

    public void set_uuid(final UUID pUuid) {
        this._uuid = pUuid;
    }

    public boolean is_inGame() {
        return this._inGame;
    }

    public void set_inGame(final boolean pInGame) {
        this._inGame = pInGame;
    }

    public int get_coinsEarned() {
        return this._coinsEarned;
    }

    public void set_coinsEarned(final int pCoinsEarned) {
        this._coinsEarned = pCoinsEarned;
    }

    public boolean is_isSpec() {
        return this._isSpec;
    }

    public void set_isSpec(final boolean pIsSpec) {
        this._isSpec = pIsSpec;
    }
}
