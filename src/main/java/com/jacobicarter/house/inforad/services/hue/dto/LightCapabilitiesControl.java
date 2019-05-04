package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightCapabilitiesControl {
    @JsonProperty("mindimlevel")
    private int minimumDimLevel;
    @JsonProperty("maxlumen")
    private int maxLumens;
    @JsonProperty("colorgamuttype")
    private String colorGamutType;
    @JsonProperty("colorgamut")
    private List<List<Float>> colorGamut;
    @JsonProperty("ct")
    private LightCapabilitiesControlColorTemperature colorTemperature;

    public LightCapabilitiesControl() {
    }

    public LightCapabilitiesControl(final int minimumDimLevel, final int maxLumens, final String colorGamutType,
                                    final List<List<Float>> colorGamut,
                                    final LightCapabilitiesControlColorTemperature colorTemperature) {
        this.minimumDimLevel = minimumDimLevel;
        this.maxLumens = maxLumens;
        this.colorGamutType = colorGamutType;
        this.colorGamut = colorGamut;
        this.colorTemperature = colorTemperature;
    }

    public int getMinimumDimLevel() {
        return minimumDimLevel;
    }

    public void setMinimumDimLevel(final int minimumDimLevel) {
        this.minimumDimLevel = minimumDimLevel;
    }

    public int getMaxLumens() {
        return maxLumens;
    }

    public void setMaxLumens(final int maxLumens) {
        this.maxLumens = maxLumens;
    }

    public String getColorGamutType() {
        return colorGamutType;
    }

    public void setColorGamutType(final String colorGamutType) {
        this.colorGamutType = colorGamutType;
    }

    public List<List<Float>> getColorGamut() {
        return colorGamut;
    }

    public void setColorGamut(final List<List<Float>> colorGamut) {
        this.colorGamut = colorGamut;
    }

    public LightCapabilitiesControlColorTemperature getColorTemperature() {
        return colorTemperature;
    }

    public void setColorTemperature(final LightCapabilitiesControlColorTemperature colorTemperature) {
        this.colorTemperature = colorTemperature;
    }
}
