package com.batmanatorul.datapack.generator;

import com.batmanatorul.datapack.DatapackElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DpWriter {
    private final File file;

    public DpWriter(File f) {
        this.file = f;
    }

    public void write(DatapackElement dpe) {
        write(dpe.format());
    }

    public void write(String s) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
