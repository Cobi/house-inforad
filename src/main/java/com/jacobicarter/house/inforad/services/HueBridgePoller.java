package com.jacobicarter.house.inforad.services;

import com.google.common.collect.ImmutableList;
import com.jacobicarter.house.inforad.config.LightDeviceConfiguration;
import com.jacobicarter.house.inforad.dto.LightDevice;
import com.jacobicarter.house.inforad.services.hue.HueApi;
import com.jacobicarter.house.inforad.services.hue.dto.Light;
import com.jacobicarter.house.inforad.services.hue.dto.LightState;

import java.awt.Color;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HueBridgePoller implements Runnable {
    private static class LightConfigPair {
        public final Light light;
        public final Optional<LightDeviceConfiguration> configuration;

        public LightConfigPair(final Light light, final Optional<LightDeviceConfiguration> configuration) {
            this.light = light;
            this.configuration = configuration;
        }
    }

    private final HueApi hueApi;
    private final List<LightDeviceConfiguration> lightDeviceConfigurations;
    private volatile List<LightDevice> devices = ImmutableList.of();

    public HueBridgePoller(final HueApi hueApi, final List<LightDeviceConfiguration> lightDeviceConfigurations) {
        this.hueApi = hueApi;
        this.lightDeviceConfigurations = lightDeviceConfigurations;
    }

    @Override
    public void run() {
        devices = hueApi.getLights().getLights().values().stream()
                .map(light -> new LightConfigPair(light, lightDeviceConfigurations.stream()
                        .filter(lightDeviceConfig -> lightDeviceConfig.getUniqueId().equals(light.getUniqueId()))
                        .findFirst()))
                .filter(lightConfigPair -> lightConfigPair.configuration.isPresent())
                .map(lightConfigPair -> new LightDevice(lightConfigPair.configuration.get().getX(),
                        lightConfigPair.configuration.get().getY(),
                        lightConfigPair.configuration.get().getZ(),
                        lightConfigPair.light.getState().isOn(),
                        getColor(lightConfigPair.light.getState())))
                .collect(Collectors.toList());
    }

    public List<LightDevice> getDevices() {
        return devices;
    }

    private String getColor(final LightState state) {
        final Color color = Color.getHSBColor(state.getHue() / 65535F,
                state.getSaturation() / 254F,
                state.getBrightness() / 254F);
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
