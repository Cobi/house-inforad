package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightCapabilities {
    @JsonProperty
    private boolean certified;
    @JsonProperty
    private LightCapabilitiesControl control;
    @JsonProperty
    private LightCapabilitiesStreaming streaming;

    public LightCapabilities() {
    }

    public LightCapabilities(final boolean certified, final LightCapabilitiesControl control,
                             final LightCapabilitiesStreaming streaming) {
        this.certified = certified;
        this.control = control;
        this.streaming = streaming;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(final boolean certified) {
        this.certified = certified;
    }

    public LightCapabilitiesControl getControl() {
        return control;
    }

    public void setControl(final LightCapabilitiesControl control) {
        this.control = control;
    }

    public LightCapabilitiesStreaming getStreaming() {
        return streaming;
    }

    public void setStreaming(final LightCapabilitiesStreaming streaming) {
        this.streaming = streaming;
    }
}
