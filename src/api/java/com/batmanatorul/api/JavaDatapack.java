package com.batmanatorul.api;

import com.batmanatorul.api.minecraft.Server;

public abstract class JavaDatapack {
    private Server server;
    protected final Options options;

    public JavaDatapack() {
        this.options = new Options();
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Options getOptions() {
        return options;
    }

    public Server getServer() {
        return server;
    }

    public abstract void onEnable();
}
