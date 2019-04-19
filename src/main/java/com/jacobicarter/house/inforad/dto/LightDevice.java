package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LightDevice extends SmartHomeDevice {
    @JsonProperty
    private boolean on;
    @JsonProperty
    private String color;

    public LightDevice(final int x, final int y, final int z, final boolean on, final String color) {
        super(x, y, z);
        this.on = on;
        this.color = color;
    }

    public boolean isOn() {
        return on;
    }

    public String getColor() {
        return color;
    }
}
