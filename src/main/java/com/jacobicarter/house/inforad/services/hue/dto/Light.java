package com.jacobicarter.house.inforad.services.hue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Light {
    @JsonProperty
    private LightState state;
    @JsonProperty("swupdate")
    private SoftwareUpdate softwareUpdate;
    @JsonProperty
    private String type;
    @JsonProperty
    private String name;
    @JsonProperty("modelid")
    private String modelId;
    @JsonProperty("manufacturername")
    private String manufacturerName;
    @JsonProperty("productname")
    private String productName;
    @JsonProperty
    private LightCapabilities capabilities;
    @JsonProperty
    private LightConfig config;
    @JsonProperty("uniqueid")
    private String uniqueId;
    @JsonProperty("swversion")
    private String softwareVersion;

    public Light() {
    }

    public Light(final LightState state, final SoftwareUpdate softwareUpdate, final String type, final String name,
                 final String modelId, final String manufacturerName, final String productName,
                 final LightCapabilities capabilities, final LightConfig config, final String uniqueId,
                 final String softwareVersion) {
        this.state = state;
        this.softwareUpdate = softwareUpdate;
        this.type = type;
        this.name = name;
        this.modelId = modelId;
        this.manufacturerName = manufacturerName;
        this.productName = productName;
        this.capabilities = capabilities;
        this.config = config;
        this.uniqueId = uniqueId;
        this.softwareVersion = softwareVersion;
    }

    public LightState getState() {
        return state;
    }

    public void setState(final LightState state) {
        this.state = state;
    }

    public SoftwareUpdate getSoftwareUpdate() {
        return softwareUpdate;
    }

    public void setSoftwareUpdate(final SoftwareUpdate softwareUpdate) {
        this.softwareUpdate = softwareUpdate;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(final String modelId) {
        this.modelId = modelId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(final String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public LightCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(final LightCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public LightConfig getConfig() {
        return config;
    }

    public void setConfig(final LightConfig config) {
        this.config = config;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(final String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(final String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }
}
