package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NetworkDevice extends SmartHomeDevice {
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private List<NetworkLink> links;

    public NetworkDevice() {

    }

    public NetworkDevice(final int x, final int y, final int z, final String name, final String address,
                         final List<NetworkLink> links) {
        super(x, y, z);
        this.name = name;
        this.address = address;
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public List<NetworkLink> getLinks() {
        return links;
    }

    public void setLinks(final List<NetworkLink> links) {
        this.links = links;
    }
}
