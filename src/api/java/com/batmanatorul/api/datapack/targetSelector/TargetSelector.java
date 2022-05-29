package com.batmanatorul.api.datapack.targetSelector;

public class TargetSelector {

    protected final String target;
    protected int limit;
    protected Sort sort;
    protected double x;
    protected double y;
    protected double z;
    protected Range radius;
    protected double pozitiveXDirection;
    protected double pozitiveYDirection;
    protected double pozitiveZDirection;
    protected Range x_rotation;
    protected Range y_rotation;
    protected String name;
    protected String NBT;
    protected Gamemode gamemode;
    protected Range xp_level;
    protected String[] tags;
    //Todo:Add team, advancements, score objectives

    public TargetSelector(Target target) {
        this(target.getFormat());
    }

    public TargetSelector(String target) {
        this.target = target;
    }

    public TargetSelector limit(int limit) {
        this.limit = limit;
        return this;
    }

    public TargetSelector sort(Sort sort) {
        this.sort = sort;
        return this;
    }

    public TargetSelector coords(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public TargetSelector radius(Range radius) {
        if (pozitiveXDirection != 0 || pozitiveZDirection != 0 || pozitiveYDirection != 0)
            throw new RuntimeException("You can't use both Radius and Pozitive Direction");

        this.radius = radius;
        return this;
    }

    public TargetSelector xRot(Range rot) {
        this.x_rotation = rot;
        return this;
    }

    public TargetSelector yRot(Range rot) {
        this.y_rotation = rot;
        return this;
    }

    public TargetSelector name(String name) {
        this.name = name;
        return this;
    }

    public TargetSelector nbt(String nbt) {
        this.NBT = nbt;
        return this;
    }

    public TargetSelector pozitiveDirection(double x, double y, double z) {
        if (radius != null)
            throw new RuntimeException("You can't use both Radius and Pozitive Direction");

        this.pozitiveXDirection = x;
        this.pozitiveYDirection = y;
        this.pozitiveZDirection = z;
        return this;
    }

    public TargetSelector gamemode(Gamemode gamemode) {
        this.gamemode = gamemode;
        return this;
    }

    public TargetSelector xpLevel(Range xp_level) {
        this.xp_level = xp_level;
        return this;
    }

    public TargetSelector tags(String... tags) {
        this.tags = tags;
        return this;
    }

    public String getName() {
        return name;
    }

    public double getPozitiveXDirection() {
        return pozitiveXDirection;
    }

    public double getPozitiveYDirection() {
        return pozitiveYDirection;
    }

    public double getPozitiveZDirection() {
        return pozitiveZDirection;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Gamemode getGamemode() {
        return gamemode;
    }

    public Range getRadius() {
        return radius;
    }

    public int getLimit() {
        return limit;
    }

    public Range getX_rotation() {
        return x_rotation;
    }

    public Range getXp_level() {
        return xp_level;
    }

    public Range getY_rotation() {
        return y_rotation;
    }

    public Sort getSort() {
        return sort;
    }

    public String getNBT() {
        return NBT;
    }

    public String getTarget() {
        return target;
    }

    public String[] getTags() {
        return tags;
    }
}
