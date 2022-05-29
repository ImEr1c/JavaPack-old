package com.batmanatorul.api.minecraft.world;

import com.batmanatorul.api.datapack.OldBlockHandling;
import com.batmanatorul.api.datapack.targetSelector.TargetSelector;
import com.batmanatorul.api.datapack.title.TitleType;
import com.batmanatorul.api.minecraft.entity.LivingEntity;

public interface World {

    /**
     * Sends a title to a TargetSelector
     * @param selector The Target
     * @param type The type of the title
     * @param text Text content of the title
     */
    void sendTitle(TargetSelector selector, TitleType type, String text);

    /**
     * Sends a title to an Entity
     * @param entity The Target Entity
     * @param type The type of the title
     * @param text Text content of the title
     */
    default void sendTitle(LivingEntity entity, TitleType type, String text) {
        sendTitle(entity.getTargetSelector(), type, text);
    }

    /**
     * Teleports a TargetSelector to a specified position
     * @param selector The TargetSelector
     * @param pos the Position to teleport to
     */
    void teleport(TargetSelector selector, Position pos);

    /**
     * Teleports a TargetSelector to another one
     * @param from The TargetSelector
     * @param to The to teleport to
     */
    void teleport(TargetSelector from, TargetSelector to);

    /**
     * Fill a space with blocks (replaces every block)
     * @param pos First Position
     * @param pos2 Second Position
     */
    default void fill(Position pos, Position pos2) {
        fill(pos, pos2, OldBlockHandling.REPLACE);
    }

    /**
     * Fill a space with blocks
     * @param pos First Position
     * @param pos2 Second Position
     * @param handling What to do with the blocks that are not air
     */
    void fill(Position pos, Position pos2, OldBlockHandling handling);
}
