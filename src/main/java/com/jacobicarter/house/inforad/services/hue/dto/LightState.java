package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightState {
    @JsonProperty
    private boolean on;
    @JsonProperty("bri")
    private int brightness;
    @JsonProperty
    private int hue;
    @JsonProperty("sat")
    private int saturation;
    @JsonProperty
    private List<Float> xy;
    @JsonProperty("ct")
    private int colorTemperature;
    @JsonProperty
    private String alert;
    @JsonProperty("colormode")
    private String colorMode;
    @JsonProperty
    private String mode;
    @JsonProperty
    private boolean reachable;

    public LightState() {
    }

    public LightState(final boolean on, final int brightness, final int hue, final int saturation, final List<Float> xy,
                      final int colorTemperature, final String alert, final String colorMode, final String mode,
                      final boolean reachable) {
        this.on = on;
        this.brightness = brightness;
        this.hue = hue;
        this.saturation = saturation;
        this.xy = xy;
        this.colorTemperature = colorTemperature;
        this.alert = alert;
        this.colorMode = colorMode;
        this.mode = mode;
        this.reachable = reachable;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(final boolean on) {
        this.on = on;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(final int brightness) {
        this.brightness = brightness;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(final int hue) {
        this.hue = hue;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(final int saturation) {
        this.saturation = saturation;
    }

    public List<Float> getXy() {
        return xy;
    }

    public void setXy(final List<Float> xy) {
        this.xy = xy;
    }

    public int getColorTemperature() {
        return colorTemperature;
    }

    public void setColorTemperature(final int colorTemperature) {
        this.colorTemperature = colorTemperature;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(final String alert) {
        this.alert = alert;
    }

    public String getColorMode() {
        return colorMode;
    }

    public void setColorMode(final String colorMode) {
        this.colorMode = colorMode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(final String mode) {
        this.mode = mode;
    }

    public boolean isReachable() {
        return reachable;
    }

    public void setReachable(final boolean reachable) {
        this.reachable = reachable;
    }
}
