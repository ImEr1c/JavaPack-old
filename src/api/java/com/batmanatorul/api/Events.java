package com.batmanatorul.api;

import com.batmanatorul.api.minecraft.Server;

public class Events {
    private Server server;

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }
}
