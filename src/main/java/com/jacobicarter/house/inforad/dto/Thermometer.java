package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thermometer extends SmartHomeDevice {
    @JsonProperty
    private int currentTempF;

    public Thermometer(final int x, final int y, final int z, final int currentTempF) {
        super(x, y, z);
        this.currentTempF = currentTempF;
    }

    public int getCurrentTempF() {
        return currentTempF;
    }
}
