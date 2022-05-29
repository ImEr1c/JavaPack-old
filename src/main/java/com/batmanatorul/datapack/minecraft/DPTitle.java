package com.batmanatorul.datapack.minecraft;

import com.batmanatorul.datapack.DatapackElement;
import com.batmanatorul.api.datapack.targetSelector.TargetSelector;
import com.batmanatorul.api.datapack.title.Title;
import com.batmanatorul.api.datapack.title.TitleType;

public class DPTitle extends Title implements DatapackElement {

    public static DPTitle toDP(Title title) {
        return new DPTitle(title.getTarget(), title.getType(), title.getText());
    }

    public DPTitle(TargetSelector target, TitleType type, String text) {
        super(target, type, text);
    }

    @Override
    public String format() {
        return new StringBuilder("title ").append(DPTargetSelector.toDP(target).format()).append(" ").append(type.name())
                .append(" ").append("\"").append(text).append("\"").toString();
    }
}
