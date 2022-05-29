package com.batmanatorul.api.minecraft.world;

public class Position {
    protected final double x;
    protected final double y;
    protected final double z;
    protected boolean fromPlayer;
    protected boolean vector;

    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position fromPlayer(boolean isVector) {
        this.fromPlayer = true;
        this.vector = isVector;
        return this;
    }

    public double getZ() {
        return z;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public boolean isFromPlayer() {
        return fromPlayer;
    }

    public boolean isVector() {
        return vector;
    }
}
