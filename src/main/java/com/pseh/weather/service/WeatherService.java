package com.pseh.weather.service;

import com.pseh.weather.data.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherForecast(String cityName);
}
