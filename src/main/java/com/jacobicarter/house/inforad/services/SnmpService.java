package com.jacobicarter.house.inforad.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jacobicarter.house.inforad.InfoRadConfiguration;
import com.jacobicarter.house.inforad.config.NetworkDeviceConfiguration;
import com.jacobicarter.house.inforad.dto.NetworkDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Singleton
public class SnmpService {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ScheduledExecutorService executor;
    private final Set<NetworkDevicePoller> pollers;

    @Inject
    public SnmpService(final ScheduledExecutorService executor, final InfoRadConfiguration configuration) {
        this.executor = executor;
        pollers = configuration.getNetworkDevices().stream()
                .map(this::start)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public List<NetworkDevice> get() {
        return pollers.stream().map(NetworkDevicePoller::get).collect(Collectors.toList());
    }

    private NetworkDevicePoller start(final NetworkDeviceConfiguration networkDeviceConfiguration) {
        try {
            final NetworkDevicePoller poller = new NetworkDevicePoller(networkDeviceConfiguration);
            executor.scheduleAtFixedRate(poller, 0, networkDeviceConfiguration.getRefreshMs(), TimeUnit.MILLISECONDS);
            return poller;
        } catch (final IOException e) {
            LOG.error("Failed to start poller: {}", networkDeviceConfiguration, e);
            return null;
        }
    }
}
