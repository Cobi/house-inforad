package com.jacobicarter.house.inforad.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jacobicarter.house.inforad.InfoRadConfiguration;
import com.jacobicarter.house.inforad.dto.Calendar;
import com.jacobicarter.house.inforad.dto.Frame;
import com.jacobicarter.house.inforad.dto.NetworkStatus;
import com.jacobicarter.house.inforad.dto.Notification;
import com.jacobicarter.house.inforad.dto.SmartHome;
import com.jacobicarter.house.inforad.dto.Time;
import com.jacobicarter.house.inforad.dto.TodoList;
import com.jacobicarter.house.inforad.dto.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import java.lang.invoke.MethodHandles;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
public class FrameService {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
    private final Set<Session> sessions = ConcurrentHashMap.newKeySet();
    private final DateTimeFormatter timeFormatter;
    private final DateTimeFormatter dateFormatter;

    @Inject
    public FrameService(final ScheduledExecutorService executor, final InfoRadConfiguration configuration) {
        LOG.info("FrameService constructed: frameDelayMs={}", configuration.getFrameDelayMs());
        timeFormatter = DateTimeFormatter.ofPattern(configuration.getTimePattern());
        dateFormatter = DateTimeFormatter.ofPattern(configuration.getDatePattern());
        executor.scheduleAtFixedRate(() -> sendFrame(), configuration.getFrameDelayMs(), configuration.getFrameDelayMs(),
                TimeUnit.MILLISECONDS);
    }

    public void addSession(final Session session) {
        sessions.add(session);
    }

    public void removeSession(final Session session) {
        sessions.remove(session);
    }

    private void sendFrame() {
        try {
            final Frame frame = generateFrame();
            final String frameJson = mapper.writeValueAsString(frame);
            sendAll(frameJson);
        } catch (final Exception ex) {
            LOG.error("Got exception generating frame:", ex);
        }
    }

    private void sendAll(final String data) {
        sessions.forEach(session -> send(session, data));
    }

    private void send(final Session session, final String data) {
        session.getAsyncRemote().sendText(data);
    }

    private Frame generateFrame() {
        return new Frame(
                generateTime(),
                generateWeather(),
                generateSmartHome(),
                generateNetworkStatus(),
                generateCalendar(),
                generateTodoList(),
                generateNotifications()
        );
    }

    private Time generateTime() {
        final Instant instant = Instant.now();
        final ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        final LocalDate localDate = zonedDateTime.toLocalDate();
        final LocalTime localTime = zonedDateTime.toLocalTime();
        final WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return new Time(dateFormatter.format(zonedDateTime), timeFormatter.format(zonedDateTime),
                DayOfWeek.from(zonedDateTime).getValue(), localDate.get(weekFields.weekOfWeekBasedYear()),
                localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth(), localTime.getHour(),
                localTime.getMinute(), localTime.getSecond(), instant.getEpochSecond());
    }

    private Weather generateWeather() {
        return new Weather(); //TODO
    }

    private SmartHome generateSmartHome() {
        return new SmartHome(ImmutableList.of(), ImmutableList.of(), ImmutableList.of(), ImmutableList.of()); //TODO
    }

    private NetworkStatus generateNetworkStatus() {
        return new NetworkStatus(0, 0, 0, 0, 0); //TODO
    }

    private Calendar generateCalendar() {
        return new Calendar(); //TODO
    }

    private TodoList generateTodoList() {
        return new TodoList(); //TODO
    }

    private Notification generateNotifications() {
        return new Notification(); //TODO;
    }
}
