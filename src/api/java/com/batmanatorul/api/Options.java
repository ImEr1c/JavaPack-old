package com.batmanatorul.api;

public class Options {
    private boolean giveCommand = true;

    public Options giveCommand(boolean b) {
        this.giveCommand = b;
        return this;
    }
}
