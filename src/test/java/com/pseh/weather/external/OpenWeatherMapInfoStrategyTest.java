package com.pseh.weather.external;

import com.pseh.weather.data.DateTimeWeatherInformation;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

public class OpenWeatherMapInfoStrategyTest {

    @Test
    public void getThreeDayWeatherInformation() {
        OpenWeatherMapConverter openWeatherMapConverter = new OpenWeatherMapConverter();

        OpenWeatherMapInfoStrategy testClass = new OpenWeatherMapInfoStrategy("b6907d289e10d714a6e88b30761fae22", openWeatherMapConverter, "https://openweathermap.org/data/2.5/forecast?q=");

        Map<LocalDateTime, DateTimeWeatherInformation> weatherForecast = testClass.getWeatherForecast("Sydney");


    }
}