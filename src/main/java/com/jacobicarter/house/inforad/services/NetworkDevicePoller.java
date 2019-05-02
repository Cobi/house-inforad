package com.jacobicarter.house.inforad.services;

import com.google.common.collect.ImmutableList;
import com.jacobicarter.house.inforad.config.NetworkDeviceConfiguration;
import com.jacobicarter.house.inforad.config.NetworkLinkConfiguration;
import com.jacobicarter.house.inforad.dto.NetworkDevice;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class NetworkDevicePoller implements Runnable {
    private final SnmpClient snmpClient;
    private final Set<NetworkLinkPoller> pollers;
    private final NetworkDevice device;

    public NetworkDevicePoller(final NetworkDeviceConfiguration configuration) throws IOException {
        if(configuration.getAddress() == null)
            snmpClient = null;
        else
            snmpClient = new SnmpClient(configuration.getAddress() + "/161", configuration.getCommunity());
        pollers = configuration.getLinks().stream().map(this::buildPoller).collect(Collectors.toSet());
        device = new NetworkDevice(configuration.getX(), configuration.getY(), configuration.getZ(),
                configuration.getName(), configuration.getAddress(), ImmutableList.of());
    }

    @Override
    public void run() {
        device.setLinks(pollers.stream().map(NetworkLinkPoller::refreshLink).collect(Collectors.toList()));
    }

    public NetworkDevice get() {
        return device;
    }

    private NetworkLinkPoller buildPoller(final NetworkLinkConfiguration networkLinkConfiguration) {
        return new NetworkLinkPoller(snmpClient, networkLinkConfiguration);
    }
}
