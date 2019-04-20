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

    public NetworkLink() {
    }

    public NetworkLink(final String otherEnd, final long rxs, final long txs, final long speed, final int vlid) {
        this.otherEnd = otherEnd;
        this.rxs = rxs;
        this.txs = txs;
        this.speed = speed;
        this.vlid = vlid;
    }

    public String getOtherEnd() {
        return otherEnd;
    }

    public void setOtherEnd(final String otherEnd) {
        this.otherEnd = otherEnd;
    }

    public long getRxs() {
        return rxs;
    }

    public void setRxs(final long rxs) {
        this.rxs = rxs;
    }

    public long getTxs() {
        return txs;
    }

    public void setTxs(final long txs) {
        this.txs = txs;
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
