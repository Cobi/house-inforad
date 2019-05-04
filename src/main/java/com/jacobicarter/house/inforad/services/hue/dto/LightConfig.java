package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightConfig {
    @JsonProperty
    private String archetype;
    @JsonProperty
    private String function;
    @JsonProperty
    private String direction;

    public LightConfig() {
    }

    public LightConfig(final String archetype, final String function, final String direction) {
        this.archetype = archetype;
        this.function = function;
        this.direction = direction;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(final String archetype) {
        this.archetype = archetype;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(final String function) {
        this.function = function;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(final String direction) {
        this.direction = direction;
    }
}
