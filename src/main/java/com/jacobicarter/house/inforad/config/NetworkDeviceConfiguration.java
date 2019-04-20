package com.jacobicarter.house.inforad.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NetworkDeviceConfiguration extends DeviceConfiguration {
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private String community;
    @JsonProperty
    private List<NetworkLinkConfiguration> links;
    @JsonProperty
    private long refreshMs;

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

    public String getCommunity() {
        return community;
    }

    public void setCommunity(final String community) {
        this.community = community;
    }

    public List<NetworkLinkConfiguration> getLinks() {
        return links;
    }

    public void setLinks(final List<NetworkLinkConfiguration> links) {
        this.links = links;
    }

    public long getRefreshMs() {
        return refreshMs;
    }

    public void setRefreshMs(final long refreshMs) {
        this.refreshMs = refreshMs;
    }
}
