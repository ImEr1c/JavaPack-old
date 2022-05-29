package com.batmanatorul.datapack.generator;

import com.batmanatorul.api.annotation.Datapack;
import com.batmanatorul.api.annotation.Event;
import com.batmanatorul.api.datapack.events.EventType;
import com.batmanatorul.api.JavaDatapack;
import com.batmanatorul.api.minecraft.Server;
import com.batmanatorul.datapack.generator.events.Events;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarReader {

    private final String description;
    private final String id;
    public static String current_Name = "";
    public static DpWriter current_writer = null;
    private final Map<EventType, Method> events = new HashMap<>();

    public JarReader(File f) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        String desc = null;
        String id = null;

        JarFile jar = new JarFile(f);
        URLClassLoader cl = new URLClassLoader(new URL[]{new URL("jar:file:" + f.getPath() + "!/")});
        PackGenerator generator = null;

        List<Class<?>> listeners = new ArrayList<>();

        for (Enumeration<JarEntry> entries = jar.entries(); entries.hasMoreElements();) {
            JarEntry e = entries.nextElement();

            if (!e.getName().endsWith(".class") || e.isDirectory())
                continue;

            Class<?> c = cl.loadClass(e.getName().replace("/",".").substring(0, e.getName().length() - 6));

            if (c.getName().contains("com.batmanatorul.datapack."))
                continue;

            if (c.getSuperclass() == JavaDatapack.class) {

                if (c.isAnnotationPresent(Datapack.class)) {

                    Datapack an = c.getAnnotation(Datapack.class);

                    desc = an.description();
                    id = an.id();

                    System.out.println("Creating new Datapack with id: " + id + ", description: " + desc);

                } else {

                    throw new RuntimeException("The class " + c.getName() + " extends JavaDatapack but doesn't have the @Datapack annotation");
                }

                generator = new PackGenerator(desc, 9, id);

                System.out.println("Datapack Created");
                JavaDatapack datapack = (JavaDatapack) c.getConstructor().newInstance();

                Method method = datapack.getClass().getMethod("setServer", Server.class);
                method.setAccessible(false);

                method.invoke(datapack, new com.batmanatorul.datapack.minecraft.Server());

                c.getMethod("onEnable").invoke(datapack);
            }

            if (c.isAnnotationPresent(Datapack.Listener.class)) {

                if (c.getSuperclass() == com.batmanatorul.api.Events.class) {

                    System.out.println("Found new listener class " + c.getName());
                    listeners.add(c);

                } else {

                    throw new RuntimeException("The class " + c.getName() + " does have the Datapack.Listener annotation but doesn't extend the Events class");
                }
            }
        }

        for (Class<?> c : listeners) {
            Method[] methods = c.getMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(Event.class)) {

                    current_Name = method.getName();

                    current_writer = new DpWriter(new File(generator.getEventsFolder(), current_Name + ".mcfunction"));

                    Event ev = method.getAnnotation(Event.class);

                    System.out.println("Found new Event named " + current_Name + " of type " + ev.event().name());

                    method.invoke(c.getConstructor().newInstance());

                    Events.getEvent(ev.event()).run(current_Name, generator);

                }
            }
        }

        this.description = desc;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
}
