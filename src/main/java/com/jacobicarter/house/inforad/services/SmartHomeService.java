package com.jacobicarter.house.inforad.services;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jacobicarter.house.inforad.dto.SmartHome;

@Singleton
public class SmartHomeService {
    private final SnmpService snmpService;

    @Inject
    public SmartHomeService(final SnmpService snmpService) {
        this.snmpService = snmpService;
    }

    public SmartHome get() {
        return new SmartHome(snmpService.get(), ImmutableList.of(), ImmutableList.of(), ImmutableList.of());
    }
}
