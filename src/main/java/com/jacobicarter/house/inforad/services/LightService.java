package com.jacobicarter.house.inforad.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jacobicarter.house.inforad.config.HueConfiguration;
import com.jacobicarter.house.inforad.dto.LightDevice;
import com.jacobicarter.house.inforad.services.hue.HueApi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Singleton
public class LightService {
    private final Set<HueBridgePoller> pollers = new HashSet<>();

    @Inject
    public LightService(final List<HueConfiguration> hueConfigurations, final ScheduledExecutorService executor) {
        hueConfigurations.forEach(hueConfiguration -> {
            final HueApi hueApi = new HueApi(hueConfiguration.getBridgeIp(), hueConfiguration.getUsername());
            final HueBridgePoller hueBridgePoller = new HueBridgePoller(hueApi, hueConfiguration.getLights());
            pollers.add(hueBridgePoller);
            executor.scheduleAtFixedRate(hueBridgePoller, 0, hueConfiguration.getRefreshMs(), TimeUnit.MILLISECONDS);
        });
    }

    public List<LightDevice> get() {
        return pollers.stream()
                .flatMap(pollers -> pollers.getDevices().stream())
                .collect(Collectors.toList());
    }
}
