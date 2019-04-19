package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkLink {
    @JsonProperty
    private String otherEnd;
    @JsonProperty
    private long rxs;
    @JsonProperty
    private long txs;
    @JsonProperty
    private long speed;
    @JsonProperty
    private int vlid;
}
