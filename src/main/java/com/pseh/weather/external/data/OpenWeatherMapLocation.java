package com.pseh.weather.external.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapLocation {
    private String name;
    private String type;
    private String country;
    private TimeZone timeZone;
    private OpenWeatherMapGeoLocation location;


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setLocation(OpenWeatherMapGeoLocation location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public OpenWeatherMapGeoLocation getLocation() {
        return location;
    }
}
