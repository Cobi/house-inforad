package com.jacobicarter.house.inforad.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jacobicarter.house.inforad.InfoRadConfiguration;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
public class SnmpService {
    private Set<NetworkDevicePoller> pollers = new HashSet<>();

    @Inject
    public SnmpService(final ScheduledExecutorService executor, final InfoRadConfiguration configuration) {

    }
}
