package com.batmanatorul.datapack.minecraft;

import com.batmanatorul.api.datapack.EffectType;
import com.batmanatorul.datapack.generator.JarReader;
import com.batmanatorul.api.datapack.targetSelector.TargetSelector;
import com.batmanatorul.api.minecraft.entity.LivingEntity;
import com.batmanatorul.api.minecraft.world.Position;

public class DPLivingEntity implements LivingEntity {

    private final TargetSelector selector;

    public DPLivingEntity(TargetSelector selector) {
        this.selector = selector;
    }

    private String getCommand() {
        return new StringBuilder("execute as ").append(DPTargetSelector.toDP(selector).format()).append(" at @s run ").toString();
    }

    public void teleport(Position pos) {
        JarReader.current_writer.write(new StringBuilder(getCommand()).append("tp ").append(DPPosition.toDP(pos).format()).toString());
    }

    @Override
    public void giveEffect(EffectType type, int seconds, int amplifier, boolean hideParticles) {
        JarReader.current_writer.write(new StringBuilder("effect give ").append(DPTargetSelector.toDP(selector).format()).append(" ").append(type.getId()).append(" ")
                .append(seconds).append(" ").append(amplifier).append(" ").append(hideParticles).toString());
    }

    @Override
    public DPTargetSelector getTargetSelector() {
        return DPTargetSelector.toDP(selector);
    }
}
