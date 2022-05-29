package com.batmanatorul.api.datapack.title;

import com.batmanatorul.api.datapack.targetSelector.TargetSelector;

public class Title {

    protected final TargetSelector target;
    protected final TitleType type;
    protected final String text;

    public Title(TargetSelector target, TitleType type, String text) {
        this.target = target;
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public TargetSelector getTarget() {
        return target;
    }

    public TitleType getType() {
        return type;
    }
}
