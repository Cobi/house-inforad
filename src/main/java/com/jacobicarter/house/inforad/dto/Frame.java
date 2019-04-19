package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Frame {
    @JsonProperty
    private Time time;
    @JsonProperty
    private Weather weather;
    @JsonProperty
    private SmartHome smartHome;
    @JsonProperty
    private NetworkStatus networkStatus;
    @JsonProperty
    private Calendar calendar;
    @JsonProperty
    private TodoList todoList;
    @JsonProperty
    private Notification notification;

    public Frame(final Time time, final Weather weather, final SmartHome smartHome, final NetworkStatus networkStatus,
                 final Calendar calendar, final TodoList todoList, final Notification notification) {
        this.time = time;
        this.weather = weather;
        this.smartHome = smartHome;
        this.networkStatus = networkStatus;
        this.calendar = calendar;
        this.todoList = todoList;
        this.notification = notification;
    }

    public Time getTime() {
        return time;
    }

    public Weather getWeather() {
        return weather;
    }

    public SmartHome getSmartHome() {
        return smartHome;
    }

    public NetworkStatus getNetworkStatus() {
        return networkStatus;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public Notification getNotification() {
        return notification;
    }
}
