package com.batmanatorul.datapack.minecraft;

import com.batmanatorul.datapack.DatapackElement;
import com.batmanatorul.api.datapack.targetSelector.Target;
import com.batmanatorul.api.datapack.targetSelector.TargetSelector;

public class DPTargetSelector extends TargetSelector implements DatapackElement {

    public static DPTargetSelector toDP(TargetSelector selector) {
        DPTargetSelector targetSelector = new DPTargetSelector(selector.getTarget());

        if (selector.getLimit() != 0)
            targetSelector.limit(selector.getLimit());

        if (selector.getSort() != null)
            targetSelector.sort(selector.getSort());

        if (selector.getX() != 0)
            targetSelector.coords(selector.getX(), selector.getY(), selector.getZ());

        if (selector.getRadius() != null)
            targetSelector.radius(selector.getRadius());

        if (selector.getX_rotation() != null)
            targetSelector.xRot(selector.getX_rotation());

        if (selector.getY_rotation() != null)
            targetSelector.yRot(selector.getY_rotation());

        if (selector.getName() != null)
            targetSelector.name(selector.getName());

        if (selector.getNBT() != null)
            targetSelector.nbt(selector.getNBT());

        if (selector.getPozitiveXDirection() != 0)
            targetSelector.pozitiveDirection(selector.getPozitiveXDirection(), selector.getPozitiveYDirection(), selector.getPozitiveZDirection());

        if (selector.getGamemode() != null)
            targetSelector.gamemode(selector.getGamemode());

        if (selector.getXp_level() != null)
            targetSelector.xpLevel(selector.getXp_level());

        if (selector.getTags() != null)
            targetSelector.tags(selector.getTags());

        return targetSelector;
    }

    public DPTargetSelector(Target target) {
        super(target);
    }

    public DPTargetSelector(String target) {
        super(target);
    }

    @Override
    public String format() {
        boolean first = true;

        StringBuilder builder = new StringBuilder(target).append("[");
        if (limit != 0) {
            builder.append("limit=").append(limit);
            first = false;
        }
        if (sort != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("sort=").append(sort.name());
        }
        if (x != 0) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("x=").append(x);
        }
        if (y != 0) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("y=").append(y);
        }
        if (z != 0) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("z=").append(z);
        }
        if (radius != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("distance=").append(DPRange.toDP(radius).format());
        }
        if (pozitiveXDirection != 0) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("dx=").append(pozitiveXDirection);
        }
        if (pozitiveYDirection != 0) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("dy=").append(pozitiveYDirection);
        }
        if (pozitiveZDirection != 0) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("dz=").append(pozitiveZDirection);
        }
        if (x_rotation != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("x_rotation=").append(DPRange.toDP(x_rotation).format());
        }
        if (y_rotation != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("y_rotation=").append(DPRange.toDP(y_rotation).format());
        }
        if (name != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("name=").append("\"").append(name).append("\"");
        }

        if (NBT != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("nbt=").append(NBT);
        }

        if (gamemode != null) {
            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("gamemode=").append(gamemode.name().toLowerCase());
        }

        if (xp_level != null) {

            if (!first)
                builder.append(",");
            else
                first = false;
            builder.append("level=").append(DPRange.toDP(xp_level).format());
        }

        if (tags != null) {
            for (String tag : tags) {
                if (!first)
                    builder.append(",");
                else
                    first = false;
                builder.append("tag=").append(tag);
            }
        }

        String result = builder.append("]").toString();

        if (result.equals(target + "[]"))
            return target;

        return result;
    }
}
