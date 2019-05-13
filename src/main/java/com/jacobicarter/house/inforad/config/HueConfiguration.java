package com.jacobicarter.house.inforad.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HueConfiguration {
    @JsonProperty
    private String bridgeIp;
    @JsonProperty
    private String username;
    @JsonProperty
    private long refreshMs;
    @JsonProperty
    private List<LightDeviceConfiguration> lights;

    public String getBridgeIp() {
        return bridgeIp;
    }

    public void setBridgeIp(final String bridgeIp) {
        this.bridgeIp = bridgeIp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public long getRefreshMs() {
        return refreshMs;
    }

    public void setRefreshMs(final long refreshMs) {
        this.refreshMs = refreshMs;
    }

    public List<LightDeviceConfiguration> getLights() {
        return lights;
    }

    public void setLights(final List<LightDeviceConfiguration> lights) {
        this.lights = lights;
    }
}
