package com.batmanatorul.datapack;

import com.batmanatorul.api.JavaDatapack;
import com.batmanatorul.datapack.generator.JarReader;
import com.batmanatorul.datapack.minecraft.World;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        System.out.println("Doing some cleanup..");
        File datapacks = new File(args[0] + ".jar");
        if (!datapacks.exists())
            throw new RuntimeException(args[0] + ".jar is not present");

        if (new File("datapack").exists())
            deleteFolder(new File("datapack").toPath());

        World.registerWorld("overworld");
        World.registerWorld("the_nether");
        World.registerWorld("the_end");

        new JarReader(datapacks);

    }

    public static void deleteFolder(Path path) {
        try {
            Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException var2) {
        }

    }
}
