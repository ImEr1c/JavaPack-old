package com.batmanatorul.api.minecraft.entity;

import com.batmanatorul.api.datapack.EffectType;
import com.batmanatorul.api.datapack.targetSelector.TargetSelector;
import com.batmanatorul.api.minecraft.world.Position;

public interface LivingEntity {

    /**
     * Gives and effect to the entity
     * @param type The type of the effect
     * @param seconds how many seconds should the effect last
     * @param amplifier the effect level (amplifier)
     * @param hideParticles if the effect should or should not have particles
     */
    void giveEffect(EffectType type, int seconds, int amplifier, boolean hideParticles);

    /**
     * Gives and effect to the entity
     * @param type The type of the effect
     * @param seconds how many seconds should the effect last
     * @param amplifier the effect level (amplifier)
     */
    default void giveEffect(EffectType type, int seconds, int amplifier) {
        giveEffect(type, seconds, amplifier, false);
    }

    /**
     * Gives and effect to the entity with the amplifier of one
     * @param type The type of the effect
     * @param seconds how many seconds should the effect last
     */
    default void giveEffect(EffectType type, int seconds) {
        giveEffect(type, seconds, 1);
    }

    /**
     * Gives and effect to the entity with the duration of 30 seconds and the amplifier of one
     * @param type The type of the effect
     */
    default void giveEffect(EffectType type) {
        giveEffect(type, 30);
    }

    /**
     * Teleports the entity to the specified position
     * @param pos Position to teleport to
     */
    void teleport(Position pos);

    /**
     * @return Target Selector used by the entity
     */
    TargetSelector getTargetSelector();
}
