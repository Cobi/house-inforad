package com.jacobicarter.house.inforad.resources;

import com.jacobicarter.house.inforad.services.FrameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.lang.invoke.MethodHandles;

@ServerEndpoint("/stream")
public class StreamResource {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static FrameService frameService;

    public static void initialize(final FrameService frameService) {
        StreamResource.frameService = frameService;
    }

    @OnOpen
    public void onOpen(final Session session) {
        LOG.info("Got new session.");
        session.setMaxIdleTimeout(1800000);
        frameService.addSession(session);
    }

    @OnClose
    public void onClose(final Session session) {
        LOG.info("Lost session.");
        frameService.removeSession(session);
    }

    @OnMessage
    public void onMessage(final String string, final Session session) {
        LOG.debug("Got message: {}", string);
    }
}
