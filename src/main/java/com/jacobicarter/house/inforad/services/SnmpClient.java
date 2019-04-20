package com.jacobicarter.house.inforad.services;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;
import java.util.Arrays;

public class SnmpClient {
    private final Snmp snmp;
    private final Target<UdpAddress> target;

    public SnmpClient(final String address, final String community) throws IOException {
        final TransportMapping<UdpAddress> transport = new DefaultUdpTransportMapping();
        snmp = new Snmp(transport);
        target = new CommunityTarget<>(new UdpAddress(address), new OctetString(community));
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        transport.listen();
    }

    public String getAsString(final OID oid) throws IOException {
        final ResponseEvent<UdpAddress> event = get(new OID[] { oid });
        return event.getResponse().get(0).getVariable().toString();
    }

    public ResponseEvent<UdpAddress> get(final OID[] oids) throws IOException {
        final PDU pdu = new PDU();
        Arrays.stream(oids)
                .map(VariableBinding::new)
                .forEach(pdu::add);
        pdu.setType(PDU.GET);
        return snmp.send(pdu, target);
    }
}
