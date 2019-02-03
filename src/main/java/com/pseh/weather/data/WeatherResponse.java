package com.pseh.weather.data;

import java.util.List;
import java.util.Objects;

public class WeatherResponse {
    private final List<DayForecast> weatherForecast;

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "weatherForecast=" + weatherForecast +
                '}';
    }

    public WeatherResponse(List<DayForecast> weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    public List<DayForecast> getWeatherForecast() {
        return weatherForecast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherResponse that = (WeatherResponse) o;
        return Objects.equals(weatherForecast, that.weatherForecast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherForecast);
    }
}
