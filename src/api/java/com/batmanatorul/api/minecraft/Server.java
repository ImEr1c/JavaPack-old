package com.batmanatorul.api.minecraft;

import com.batmanatorul.api.minecraft.world.World;

public interface Server {
    /**
     * Get the overworld world
     * @return the overworld
     */
    World getWorld();

    /**
     * Get a world by a specific ID
     * @param id The id of the world
     * @return The world
     */
    World getWordById(String id);
}
