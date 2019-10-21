package de.t23t.tntrun.utils;

public class TNTPlayer {

    private boolean buildMode;

    public TNTPlayer() {
        this.buildMode = false;
    }

    public boolean isBuildMode() {
        return buildMode;
    }

    public void setBuildMode(boolean buildMode) {
        this.buildMode = buildMode;
    }
}
