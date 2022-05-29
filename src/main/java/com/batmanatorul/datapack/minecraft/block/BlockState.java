package com.batmanatorul.datapack.minecraft.block;

import java.util.HashMap;
import java.util.Map;

public class BlockState {
    private final Map<String, Object> map;

    public BlockState() {
        map = new HashMap<>();
    }

    public<A extends Object> BlockState with(String str, A obj) {
        map.put(str, obj);
        return this;
    }
}
