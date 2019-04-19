package com.jacobicarter.house.inforad;

import com.hubspot.dropwizard.guicier.GuiceBundle;
import com.jacobicarter.house.inforad.resources.StreamResource;
import com.jacobicarter.house.inforad.services.FrameService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.websockets.WebsocketBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class InfoRadApplication extends Application<InfoRadConfiguration> {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private GuiceBundle<InfoRadConfiguration> guiceBundle;

    @Override
    public String getName() {
        return "house-inforad";
    }

    @Override
    public void initialize(final Bootstrap<InfoRadConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.defaultBuilder(InfoRadConfiguration.class)
                .modules(new InfoRadGuiceModule())
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new WebsocketBundle(StreamResource.class));
    }

    @Override
    public void run(final InfoRadConfiguration configuration, final Environment environment) throws Exception {
        StreamResource.initialize(guiceBundle.getInjector().getInstance(FrameService.class));
    }

    public static void main(final String[] args) throws Exception {
        new InfoRadApplication().run(args);
    }
}
