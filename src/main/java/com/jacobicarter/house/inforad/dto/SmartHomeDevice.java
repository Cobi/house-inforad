package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SmartHomeDevice {
    @JsonProperty
    private int x;
    @JsonProperty
    private int y;
    @JsonProperty
    private int z;

    public SmartHomeDevice(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
