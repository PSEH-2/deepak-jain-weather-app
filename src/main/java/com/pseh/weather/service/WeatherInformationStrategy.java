package com.pseh.weather.service;

import com.pseh.weather.data.DateTimeWeatherInformation;

import java.time.LocalDateTime;
import java.util.Map;

public interface WeatherInformationStrategy {
    Map<LocalDateTime, DateTimeWeatherInformation> getWeatherForecast(final String city);
}
