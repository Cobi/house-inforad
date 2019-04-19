package com.jacobicarter.house.inforad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Time {
    @JsonProperty
    private String formattedDate;
    @JsonProperty
    private String formattedTime;
    @JsonProperty
    private int dayOfWeek;
    @JsonProperty
    private int weekOfYear;
    @JsonProperty
    private int year;
    @JsonProperty
    private int month;
    @JsonProperty
    private int day;
    @JsonProperty
    private int hour;
    @JsonProperty
    private int minute;
    @JsonProperty
    private int second;
    @JsonProperty
    private long unixTime;

    public Time(final String formattedDate, final String formattedTime, final int dayOfWeek, final int weekOfYear,
                final int year, final int month, final int day, final int hour, final int minute, final int second,
                final long unixTime) {
        this.formattedDate = formattedDate;
        this.formattedTime = formattedTime;
        this.dayOfWeek = dayOfWeek;
        this.weekOfYear = weekOfYear;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.unixTime = unixTime;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getWeekOfYear() {
        return weekOfYear;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public long getUnixTime() {
        return unixTime;
    }
}
