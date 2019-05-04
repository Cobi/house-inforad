package com.jacobicarter.house.inforad.services.hue;

import com.jacobicarter.house.inforad.services.hue.resources.LightsResource;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class HueApi {
    public static final String ACCEPT = "application/json";

    private final LightsResource lights;

    public HueApi(final String bridgeIp, final String username) {
        final Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        final WebTarget apiBase = client.target("http://" + bridgeIp)
                .path("api").path(username);
        lights = new LightsResource(apiBase.path("lights"));
    }

    public LightsResource getLights() {
        return lights;
    }
}
