package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SmartHome {
    @JsonProperty
    private List<NetworkDevice> networkDevices;
    @JsonProperty
    private List<LightDevice> lightDevices;
    @JsonProperty
    private List<Thermometer> thermometers;
    @JsonProperty
    private List<SoundDevice> soundDevices;

    public SmartHome(final List<NetworkDevice> networkDevices, final List<LightDevice> lightDevices,
                     final List<Thermometer> thermometers, final List<SoundDevice> soundDevices) {
        this.networkDevices = networkDevices;
        this.lightDevices = lightDevices;
        this.thermometers = thermometers;
        this.soundDevices = soundDevices;
    }

    public List<NetworkDevice> getNetworkDevices() {
        return networkDevices;
    }

    public List<LightDevice> getLightDevices() {
        return lightDevices;
    }

    public List<Thermometer> getThermometers() {
        return thermometers;
    }

    public List<SoundDevice> getSoundDevices() {
        return soundDevices;
    }
}
