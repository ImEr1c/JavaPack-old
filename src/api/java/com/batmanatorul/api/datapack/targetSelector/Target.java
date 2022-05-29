package com.batmanatorul.api.datapack.targetSelector;

public enum Target {
    Nearest_Player("@p"),
    Random_player("@r"),
    All_Players("@a"),

    //The player that executes the command
    Self("@s");

    String format;

    Target(String f) {
        this.format = f;
    }

    public String getFormat() {
        return format;
    }
}
