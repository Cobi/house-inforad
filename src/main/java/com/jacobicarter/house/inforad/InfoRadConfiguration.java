package com.jacobicarter.house.inforad;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jacobicarter.house.inforad.config.NetworkDeviceConfiguration;
import io.dropwizard.Configuration;

import java.util.List;

public class InfoRadConfiguration extends Configuration {
    @JsonProperty
    private String timePattern;
    @JsonProperty
    private String datePattern;
    @JsonProperty
    private int frameDelayMs;
    @JsonProperty
    private List<NetworkDeviceConfiguration> networkDevices;


    public void setTimePattern(final String timePattern) {
        this.timePattern = timePattern;
    }

    public String getTimePattern() {
        return timePattern;
    }

    public void setDatePattern(final String datePattern) {
        this.datePattern = datePattern;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setFrameDelayMs(final int frameDelayMs) {
        this.frameDelayMs = frameDelayMs;
    }

    public int getFrameDelayMs() {
        return frameDelayMs;
    }

    public List<NetworkDeviceConfiguration> getNetworkDevices() {
        return networkDevices;
    }

    public void setNetworkDevices(final List<NetworkDeviceConfiguration> networkDevices) {
        this.networkDevices = networkDevices;
    }
}
