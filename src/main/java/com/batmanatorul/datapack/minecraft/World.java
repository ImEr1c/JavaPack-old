package com.batmanatorul.datapack.minecraft;

import com.batmanatorul.api.datapack.OldBlockHandling;
import com.batmanatorul.api.datapack.targetSelector.TargetSelector;
import com.batmanatorul.api.datapack.title.TitleType;
import com.batmanatorul.datapack.generator.JarReader;
import com.batmanatorul.api.minecraft.world.Position;

import java.util.HashMap;
import java.util.Map;

public class World implements com.batmanatorul.api.minecraft.world.World {

    private String id;

    private static final Map<String, World> world_ids = new HashMap<>();

    public static World getWorld(String id) {
        if (!world_ids.containsKey(id))
            throw new RuntimeException("World does not exist");

        return world_ids.get(id);
    }

    private World() {
        //Blank
    }

    public static void registerWorld(String id) {
        world_ids.put(id, new World());
    }

    public void sendTitle(TargetSelector selector, TitleType type, String text) {
        JarReader.current_writer.write(new StringBuilder("title ").append(DPTargetSelector.toDP(selector).format()).append(" ").append(type.name())
                .append(" ").append("\"").append(text).append("\"").toString());
    }

    public void teleport(TargetSelector selector, Position pos) {
        JarReader.current_writer.write(new StringBuilder("tp").append(DPTargetSelector.toDP(selector).format()).append(" ").append(DPPosition.toDP(pos).format()).toString());
    }

    public void teleport(TargetSelector from, TargetSelector to) {
        JarReader.current_writer.write(new StringBuilder("tp ").append(DPTargetSelector.toDP(from).format()).append(" ").append(DPTargetSelector.toDP(to).format()).toString());
    }

    public void fill(Position pos, Position pos2, OldBlockHandling handling) {
        JarReader.current_writer.write(new StringBuilder("fill ").append(DPPosition.toDP(pos).format()).append(" ").append(DPPosition.toDP(pos2).format()).append(" ")
                .append(handling.name().toLowerCase()).toString());
    }
}
