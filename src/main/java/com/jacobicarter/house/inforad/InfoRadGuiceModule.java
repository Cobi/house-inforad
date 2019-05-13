package com.jacobicarter.house.inforad;

import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;
import com.jacobicarter.house.inforad.services.FrameService;
import com.jacobicarter.house.inforad.services.LightService;
import com.jacobicarter.house.inforad.services.SmartHomeService;
import com.jacobicarter.house.inforad.services.SnmpService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class InfoRadGuiceModule extends DropwizardAwareModule<InfoRadConfiguration> {
    @Override
    public void configure(final Binder binder) {
        binder.bind(FrameService.class);
        binder.bind(SmartHomeService.class);
        binder.bind(SnmpService.class);
        binder.bind(LightService.class);
    }

    @Provides
    @Singleton
    public ScheduledExecutorService getScheduledExecutorService() {
        return Executors.newScheduledThreadPool(5);
    }
}
