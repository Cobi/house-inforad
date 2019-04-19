package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThermostatDevice extends Thermometer {
    @JsonProperty
    private boolean isCooling;
    @JsonProperty
    private boolean isHeating;
    @JsonProperty
    private int targetTempF;

    public ThermostatDevice(final int x, final int y, final int z, final int currentTempF, final boolean isCooling,
                            final boolean isHeating, final int targetTempF) {
        super(x, y, z, currentTempF);
        this.isCooling = isCooling;
        this.isHeating = isHeating;
        this.targetTempF = targetTempF;
    }

    public boolean isCooling() {
        return isCooling;
    }

    public boolean isHeating() {
        return isHeating;
    }

    public int getTargetTempF() {
        return targetTempF;
    }
}
