package com.batmanatorul.datapack.generator.events;

import com.batmanatorul.datapack.generator.PackGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TickEvent implements GenEvent {
    @Override
    public void run(String name, PackGenerator generator) throws IOException {
        FileWriter writer = new FileWriter(new File(generator.getFunctionsFolder(), "tick.mcfunction"));
        writer.write("function " + generator.getId() + ":events/" + name);
        writer.close();
    }
}
