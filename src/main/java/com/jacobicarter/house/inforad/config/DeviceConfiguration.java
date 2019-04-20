package com.jacobicarter.house.inforad.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class DeviceConfiguration {
    @JsonProperty
    private int x;
    @JsonProperty
    private int y;
    @JsonProperty
    private int z;

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(final int z) {
        this.z = z;
    }
}
