package com.batmanatorul.datapack.minecraft;

import com.batmanatorul.datapack.DatapackElement;
import com.batmanatorul.api.minecraft.world.Position;

public class DPPosition extends Position implements DatapackElement {

    public static DPPosition toDP(Position pos) {
        DPPosition position = new DPPosition(pos.getX(), pos.getY(), pos.getZ());

        if (pos.isFromPlayer())
            position.fromPlayer(pos.isVector());

        return position;
    }

    public DPPosition(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public String format() {
        StringBuilder builder = new StringBuilder();

        if (fromPlayer) {
            if (vector) {
                builder.append("^").append(x).append(" ").append("^").append(y).append(" ").append("^").append(z);
            } else {
                builder.append("~").append(x).append(" ").append("~").append(y).append(" ").append("~").append(z);
            }
        } else {
            builder.append(x).append(" ").append(y).append(" ").append(z);
        }

        return builder.toString();
    }
}
