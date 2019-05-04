package com.jacobicarter.house.inforad.services.hue.resources;

import com.jacobicarter.house.inforad.services.hue.HueApi;
import com.jacobicarter.house.inforad.services.hue.dto.Light;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.Map;

public class LightsResource {
    private final WebTarget lights;

    public LightsResource(final WebTarget lights) {
        this.lights = lights;
    }

    public Map<String, Light> getLights() {
        return lights
                .request(HueApi.ACCEPT)
                .get(new GenericType<Map<String, Light>>() {});
    }
}
