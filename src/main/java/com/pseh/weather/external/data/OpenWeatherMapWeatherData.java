package com.pseh.weather.external.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapWeatherData {
    private OpenWeatherMapLocation location;

    public OpenWeatherMapLocation getLocation() {
        return location;
    }

    public void setLocation(OpenWeatherMapLocation location) {
        this.location = location;
    }
}
