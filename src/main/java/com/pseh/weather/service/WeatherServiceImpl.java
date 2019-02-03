package com.pseh.weather.service;

import com.pseh.weather.data.DateTimeWeatherInformation;
import com.pseh.weather.data.DayForecast;
import com.pseh.weather.data.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherInformationStrategy weatherInformationStrategy;

    private final Integer forecastRequiredFor;

    public WeatherServiceImpl(@Autowired WeatherInformationStrategy weatherInformationStrategy,@Value("${forecastRequiredFor:3}") Integer forecastRequiredFor) {
        this.weatherInformationStrategy = weatherInformationStrategy;
        this.forecastRequiredFor = forecastRequiredFor;
    }

    @Override
    public WeatherResponse getWeatherForecast(String cityName) {
        List<DayForecast> forecasts = new ArrayList<>();

        Map<LocalDateTime, DateTimeWeatherInformation> weatherForecast = weatherInformationStrategy.getWeatherForecast(cityName);

        LocalDate currentDate = getNow();

        for (int i = 1; i <= forecastRequiredFor; i++) {
            forecasts.add(getForecast(weatherForecast, currentDate.plusDays(i)));
        }

        return new WeatherResponse(forecasts);
    }

    protected LocalDate getNow() {
        return LocalDate.now(Clock.systemDefaultZone());
    }

    private DayForecast getForecast(Map<LocalDateTime, DateTimeWeatherInformation> weatherForecast, LocalDate date) {
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        Set<String> messages = new HashSet<>();
        for (LocalDateTime localDateTime : weatherForecast.keySet()) {
            if (localDateTime.toLocalDate().equals(date)) {
                DateTimeWeatherInformation dateTimeWeatherInformation = weatherForecast.get(localDateTime);
                if (maxTemp < dateTimeWeatherInformation.getMaxTemp()) {
                    maxTemp = dateTimeWeatherInformation.getMaxTemp();
                }
                if (minTemp > dateTimeWeatherInformation.getMinTemp()) {
                    minTemp = dateTimeWeatherInformation.getMinTemp();
                }
                if (dateTimeWeatherInformation.getWillRain()) {
                    messages.add("Carry Umbrella");
                }

                if (maxTemp > 40.0D){
                    messages.add("Use suncreen lotion");
                }

            }
        }
        return new DayForecast(date.format(DateTimeFormatter.ISO_DATE), String.valueOf(maxTemp), String.valueOf(minTemp), messages);
    }

}
