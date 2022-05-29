package com.batmanatorul.datapack.minecraft;

import com.batmanatorul.datapack.DatapackElement;
import com.batmanatorul.api.datapack.targetSelector.Range;

public class DPRange extends Range implements DatapackElement {
    public DPRange(double min, double max) {
        super(min, max);
    }

    public static DPRange toDP(Range range) {
        return new DPRange(range.getMin(), range.getMax());
    }

    @Override
    public String format() {
        return new StringBuilder().append(min).append("..").append(max).toString();
    }
}
