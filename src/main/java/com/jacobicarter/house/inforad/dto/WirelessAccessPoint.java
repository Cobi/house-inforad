package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WirelessAccessPoint extends NetworkDevice {
    @JsonProperty
    private int clients;
    @JsonProperty
    private int clients5Ghz;
    @JsonProperty
    private int clients24Ghz;

    public WirelessAccessPoint(final int x, final int y, final int z, final String name, final String address,
                               final List<NetworkLink> links, final int clients, final int clients5Ghz,
                               final int clients24Ghz) {
        super(x, y, z, name, address, links);
        this.clients = clients;
        this.clients5Ghz = clients5Ghz;
        this.clients24Ghz = clients24Ghz;
    }

    public int getClients() {
        return clients;
    }

    public int getClients5Ghz() {
        return clients5Ghz;
    }

    public int getClients24Ghz() {
        return clients24Ghz;
    }
}
