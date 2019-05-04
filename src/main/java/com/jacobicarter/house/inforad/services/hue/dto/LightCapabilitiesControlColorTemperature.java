package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightCapabilitiesControlColorTemperature {
    @JsonProperty
    private int min;
    @JsonProperty
    private int max;

    public LightCapabilitiesControlColorTemperature() {
    }

    public LightCapabilitiesControlColorTemperature(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(final int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(final int max) {
        this.max = max;
    }
}
