package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkStatus {
    @JsonProperty
    private int wirelessCount;
    @JsonProperty
    private int deviceCount;
    @JsonProperty
    private int internetRxs;
    @JsonProperty
    private int internetTxs;
    @JsonProperty
    private int internetLatencyMs;

    public NetworkStatus(final int wirelessCount, final int deviceCount, final int internetRxs, final int internetTxs,
                         final int internetLatencyMs) {
        this.wirelessCount = wirelessCount;
        this.deviceCount = deviceCount;
        this.internetRxs = internetRxs;
        this.internetTxs = internetTxs;
        this.internetLatencyMs = internetLatencyMs;
    }

    public int getWirelessCount() {
        return wirelessCount;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public int getInternetRxs() {
        return internetRxs;
    }

    public int getInternetTxs() {
        return internetTxs;
    }

    public int getInternetLatencyMs() {
        return internetLatencyMs;
    }
}
