package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightCapabilitiesStreaming {
    @JsonProperty
    private boolean renderer;
    @JsonProperty
    private boolean proxy;

    public LightCapabilitiesStreaming() {
    }

    public LightCapabilitiesStreaming(final boolean renderer, final boolean proxy) {
        this.renderer = renderer;
        this.proxy = proxy;
    }

    public boolean isRenderer() {
        return renderer;
    }

    public void setRenderer(final boolean renderer) {
        this.renderer = renderer;
    }

    public boolean isProxy() {
        return proxy;
    }

    public void setProxy(final boolean proxy) {
        this.proxy = proxy;
    }
}
