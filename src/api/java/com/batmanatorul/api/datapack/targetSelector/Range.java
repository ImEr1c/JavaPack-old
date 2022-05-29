package com.batmanatorul.api.datapack.targetSelector;

public class Range {
    protected final double min;
    protected final double max;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
