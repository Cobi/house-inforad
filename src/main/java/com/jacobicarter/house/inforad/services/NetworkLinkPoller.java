package com.jacobicarter.house.inforad.services;

import com.jacobicarter.house.inforad.config.NetworkLinkConfiguration;
import com.jacobicarter.house.inforad.dto.NetworkLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.PDU;
import org.snmp4j.smi.OID;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Date;

public class NetworkLinkPoller {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final SnmpClient snmpClient;
    private final NetworkLinkConfiguration networkLinkConfiguration;
    private long lastRx = -1;
    private long lastTx = -1;
    private long lastTs = -1;

    public NetworkLinkPoller(final SnmpClient snmpClient, final NetworkLinkConfiguration networkLinkConfiguration) {
        this.snmpClient = snmpClient;
        this.networkLinkConfiguration = networkLinkConfiguration;
    }

    NetworkLink refreshLink() {
        try {
            final OID rxOid = new OID(networkLinkConfiguration.getRxbOid());
            final OID txOid = new OID(networkLinkConfiguration.getTxbOid());
            final PDU response = snmpClient.get(new OID[]{rxOid, txOid}).getResponse();
            final long ts = new Date().getTime();
            final long rx = response.get(0).getVariable().toLong();
            final long tx = response.get(1).getVariable().toLong();
            if(lastTs == -1) {
                lastTs = ts;
                lastRx = rx;
                lastTx = tx;
                return new NetworkLink(networkLinkConfiguration.getTarget(), 0, 0,
                        networkLinkConfiguration.getSpeed(), networkLinkConfiguration.getVlid());
            }
            final long tsDiff = ts - lastTs;
            final long txs = (tx - lastTx) * 1000 / tsDiff;
            final long rxs = (rx - lastRx) * 1000 / tsDiff;
            lastTs = ts;
            lastRx = rx;
            lastTx = tx;
            return new NetworkLink(networkLinkConfiguration.getTarget(), rxs, txs, networkLinkConfiguration.getSpeed(),
                    networkLinkConfiguration.getVlid());
        } catch (final IOException ex) {
            LOG.warn("Got exception polling OIDs:", ex);
            return null;
        }
    }

}
