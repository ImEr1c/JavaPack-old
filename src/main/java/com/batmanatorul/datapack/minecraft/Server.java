package com.batmanatorul.datapack.minecraft;

public class Server implements com.batmanatorul.api.minecraft.Server {
    @Override
    public World getWorld() {
        return World.getWorld("overworld");
    }

    @Override
    public com.batmanatorul.api.minecraft.world.World getWordById(String id) {
        return World.getWorld(id);
    }
}
