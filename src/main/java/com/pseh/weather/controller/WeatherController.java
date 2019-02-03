package com.pseh.weather.controller;

import com.pseh.weather.data.WeatherResponse;
import com.pseh.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {


    private final WeatherService weatherService;

    public WeatherController(@Autowired WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/weather")
    public ResponseEntity<WeatherResponse> weather(@RequestParam String cityName) {
        return ResponseEntity.ok(weatherService.getWeatherForecast(cityName));
    }

}
