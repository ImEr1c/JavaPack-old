package com.batmanatorul.datapack.generator.events;

import com.batmanatorul.api.datapack.events.EventType;

public class Events {
    public static GenEvent getEvent(EventType type) {
        return switch (type) {
            default -> new TickEvent();
        };
    }
}
