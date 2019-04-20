package com.jacobicarter.house.inforad.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkLinkConfiguration {
    @JsonProperty
    private String target;
    @JsonProperty
    private String rxbOid;
    @JsonProperty
    private String txbOid;
    @JsonProperty
    private long speed;
    @JsonProperty
    private int vlid;

    public String getTarget() {
        return target;
    }

    public void setTarget(final String target) {
        this.target = target;
    }

    public String getRxbOid() {
        return rxbOid;
    }

    public void setRxbOid(final String rxbOid) {
        this.rxbOid = rxbOid;
    }

    public String getTxbOid() {
        return txbOid;
    }

    public void setTxbOid(final String txbOid) {
        this.txbOid = txbOid;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(final long speed) {
        this.speed = speed;
    }

    public int getVlid() {
        return vlid;
    }

    public void setVlid(final int vlid) {
        this.vlid = vlid;
    }
}
