package com.jacobicarter.house.inforad.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LightDeviceConfiguration extends DeviceConfiguration {
    @JsonProperty
    private String name;
    @JsonProperty
    private String uniqueId;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(final String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
