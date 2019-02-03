package com.pseh.weather.service;

import com.pseh.weather.data.DateTimeWeatherInformation;
import com.pseh.weather.data.DayForecast;
import com.pseh.weather.data.WeatherResponse;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.*;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class WeatherServiceImplTest {

    @Test
    public void getWeatherForecast() {
        //given
        WeatherInformationStrategy weatherInformationStrategy = Mockito.mock(WeatherInformationStrategy.class);
        String cityName = "Delhi";
        Map<LocalDateTime, DateTimeWeatherInformation> weatherMap = new HashMap<>();
        LocalDateTime tomorrowNoon = LocalDateTime.of(2019, 02, 4, 12, 0);
        LocalDateTime tomorrowFive = LocalDateTime.of(2019, 02, 4, 17, 0);
        LocalDateTime dayAfterNoon = LocalDateTime.of(2019, 02, 5, 12, 0);
        LocalDateTime dayAfterFive = LocalDateTime.of(2019, 02, 5, 17, 0);
        LocalDateTime anotherDayAfterNoon = LocalDateTime.of(2019, 02, 6, 12, 0);
        LocalDateTime anotherDayAfterFive = LocalDateTime.of(2019, 02, 6, 17, 0);
        weatherMap.put(tomorrowNoon, new DateTimeWeatherInformation(tomorrowNoon, 31.5, 2.5, true));
        weatherMap.put(tomorrowFive, new DateTimeWeatherInformation(tomorrowNoon, 30.5, 1.5, false));
        weatherMap.put(dayAfterNoon, new DateTimeWeatherInformation(tomorrowNoon, 31.5, 2.5, false));
        weatherMap.put(dayAfterFive, new DateTimeWeatherInformation(tomorrowNoon, 32.5, 3.5, true));
        weatherMap.put(anotherDayAfterNoon, new DateTimeWeatherInformation(tomorrowNoon, 31.5, 2.5, false));
        weatherMap.put(anotherDayAfterFive, new DateTimeWeatherInformation(tomorrowNoon, 40.5, 1.5, false));

        when(weatherInformationStrategy.getWeatherForecast(cityName)).thenReturn(weatherMap);

        WeatherServiceImpl testClass = new WeatherServiceImpl(weatherInformationStrategy, 3){
            @Override
            protected LocalDate getNow() {
                Clock clock = Clock.fixed(Instant.parse("2019-02-03T10:15:30.00Z"), ZoneId.of("UTC"));
                return LocalDate.now(clock);
            }
        };

        //when
        WeatherResponse result = testClass.getWeatherForecast(cityName);

        //then
        List<DayForecast> forecasts = new ArrayList<>();
        forecasts.add(new DayForecast("2019-02-04", "31.5", "1.5", Sets.newTreeSet("Carry Umbrella")));
        forecasts.add(new DayForecast("2019-02-05", "32.5", "2.5", Sets.newTreeSet("Carry Umbrella")));
        forecasts.add(new DayForecast("2019-02-06", "40.5", "1.5", Sets.newTreeSet("Use suncreen lotion")));
        WeatherResponse expectedWeather = new WeatherResponse(forecasts);
        assertEquals(expectedWeather, result);
    }
}