package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SoftwareUpdate {
    @JsonProperty
    private String state;
    @JsonProperty("lastinstall")
    private String lastInstall;

    public SoftwareUpdate() {
    }

    public SoftwareUpdate(final String state, final String lastInstall) {
        this.state = state;
        this.lastInstall = lastInstall;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getLastInstall() {
        return lastInstall;
    }

    public void setLastInstall(final String lastInstall) {
        this.lastInstall = lastInstall;
    }
}
