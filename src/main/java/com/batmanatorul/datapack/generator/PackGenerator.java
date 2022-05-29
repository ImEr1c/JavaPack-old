package com.batmanatorul.datapack.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PackGenerator {

    public static final File out = new File("datapack");
    private final String id;
    private final File funcs;
    private final File events;

    public PackGenerator(String description, int version, String id) throws IOException {
        checkAndCreate(out);

        checkAndCreate(out);

        File data = new File(out, "data");
        checkAndCreate(data);

        File pack = new File(out, "pack.mcmeta");

        try {
            FileWriter writer = new FileWriter(pack);
            writer.write(" {\n" +
                    "       \"pack\": {\n" +
                    "           \"pack_format\": " + version + ",\n" +
                    "           \"description\": \"" + description +"\"\n" +
                    "       }\n" +
                    "   }");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File minecraft = new File(data, "minecraft");
        checkAndCreate(minecraft);

        File main = new File(data, id);
        checkAndCreate(main);

        File mc_tags = new File(minecraft, "tags");
        checkAndCreate(mc_tags);

        File mc_funcs = new File(mc_tags, "functions");
        checkAndCreate(mc_funcs);

        File load = new File(mc_funcs, "load.json");

        try {
            FileWriter writer = new FileWriter(load);
            writer.write("{\n" +
                    "    \"values\": [\n" +
                    "    \"" + id + ":setup\"\n" +
                    "    ]\n" +
                    "   }");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File tick = new File(mc_funcs, "tick.json");

        try {
            FileWriter writer = new FileWriter(tick );
            writer.write("{\n" +
                    "    \"values\": [\n" +
                    "    \"" + id + ":tick\"\n" +
                    "    ]\n" +
                    "   }");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File functions = new File(main, "functions");
        checkAndCreate(functions);

        new File(functions, "setup.mcfunction").createNewFile();
        new File(functions, "tick.mcfunction").createNewFile();

        this.funcs = functions;
        this.events = new File(functions, "events");
        this.id = id;
        checkAndCreate(events);
    }

    private void checkAndCreate(File f) {
        if (!f.exists()) f.mkdir();
    }

    public File getFunctionsFolder() {
        return funcs;
    }

    public File getEventsFolder() {
        return events;
    }

    public String getId() {
        return id;
    }
}
