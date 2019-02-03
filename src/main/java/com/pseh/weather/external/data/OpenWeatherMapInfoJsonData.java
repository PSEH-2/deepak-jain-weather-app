package com.pseh.weather.external.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapInfoJsonData {
    private OpenWeatherMapWeatherData weatherData;

    public OpenWeatherMapWeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(OpenWeatherMapWeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
