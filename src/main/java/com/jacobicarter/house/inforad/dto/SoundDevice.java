package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoundDevice extends SmartHomeDevice {
    @JsonProperty
    private boolean isPlaying;
    @JsonProperty
    private int volume;
    @JsonProperty
    private String media;

    public SoundDevice(final int x, final int y, final int z, final boolean isPlaying, final int volume,
                       final String media) {
        super(x, y, z);
        this.isPlaying = isPlaying;
        this.volume = volume;
        this.media = media;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public int getVolume() {
        return volume;
    }

    public String getMedia() {
        return media;
    }
}
