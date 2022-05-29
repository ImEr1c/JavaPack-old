package com.batmanatorul.datapack.generator.events;

import com.batmanatorul.datapack.generator.PackGenerator;

import java.io.IOException;

public interface GenEvent {
    void run(String name, PackGenerator gen) throws IOException;
}
