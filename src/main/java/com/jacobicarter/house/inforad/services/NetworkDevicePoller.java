package com.jacobicarter.house.inforad.services;

import com.google.common.collect.ImmutableList;
import com.jacobicarter.house.inforad.config.NetworkDeviceConfiguration;
import com.jacobicarter.house.inforad.config.NetworkLinkConfiguration;
import com.jacobicarter.house.inforad.dto.NetworkDevice;
import com.jacobicarter.house.inforad.dto.NetworkLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.PDU;
import org.snmp4j.smi.OID;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

public class NetworkDevicePoller implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final SnmpClient snmpClient;
    private final List<NetworkLinkConfiguration> links;
    private final NetworkDevice device;

    public NetworkDevicePoller(final NetworkDeviceConfiguration configuration) throws IOException {
        snmpClient = new SnmpClient(configuration.getAddress() + ":161", configuration.getCommunity());
        links = configuration.getLinks();
        device = new NetworkDevice(configuration.getX(), configuration.getY(), configuration.getZ(),
                configuration.getName(), configuration.getAddress(), ImmutableList.of());
    }

    @Override
    public void run() {
        device.setLinks(links.stream().map(this::refreshLink).collect(Collectors.toList()));
    }

    private NetworkLink refreshLink(final NetworkLinkConfiguration networkLinkConfiguration) {
        try {
            final OID rxOid = new OID(networkLinkConfiguration.getRxbOid());
            final OID txOid = new OID(networkLinkConfiguration.getTxbOid());
            final PDU response = snmpClient.get(new OID[]{rxOid, txOid}).getResponse();
            return new NetworkLink(networkLinkConfiguration.getTarget(), response.get(0).getVariable().toLong(),
                    response.get(1).getVariable().toLong(), networkLinkConfiguration.getSpeed(),
                    networkLinkConfiguration.getVlid()); //TODO: Convert to per second.
        } catch (final IOException ex) {
            LOG.warn("Got exception polling OIDs from: {}", device.getName(), ex);
            return null;
        }
    }
}
