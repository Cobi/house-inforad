package com.jacobicarter.house.inforad.services;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jacobicarter.house.inforad.dto.SmartHome;

@Singleton
public class SmartHomeService {
    private final SnmpService snmpService;
    private final LightService lightService;

    @Inject
    public SmartHomeService(final SnmpService snmpService, final LightService lightService) {
        this.snmpService = snmpService;
        this.lightService = lightService;
    }

    public SmartHome get() {
        return new SmartHome(snmpService.get(), lightService.get(), ImmutableList.of(), ImmutableList.of());
    }
}
