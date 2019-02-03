package com.pseh.weather.external;

import com.pseh.external.data.gen.OpenWeatherMapWeather;
import com.pseh.weather.data.DateTimeWeatherInformation;
import com.pseh.weather.service.WeatherInformationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class OpenWeatherMapInfoStrategy implements WeatherInformationStrategy {

    private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapInfoStrategy.class);

    private final String appId;

    private final OpenWeatherMapConverter openWeatherMapConverter;

    private final String forecastAPIUrl;

    public OpenWeatherMapInfoStrategy(@Value("${appId:b6907d289e10d714a6e88b30761fae22}") String appId,
                                      @Autowired OpenWeatherMapConverter openWeatherMapConverter,
                                      @Value("${apiUrl:https://openweathermap.org/data/2.5/forecast?q=}")String forecastAPIUrl) {
        this.appId = appId;
        this.openWeatherMapConverter = openWeatherMapConverter;
        this.forecastAPIUrl = forecastAPIUrl;
    }

    @Override
    public Map<LocalDateTime, DateTimeWeatherInformation> getWeatherForecast(final String city){
        RestTemplate restTemplate = new RestTemplate();
        String url = forecastAPIUrl + city + "&appid=" + appId + "&units=metric";
        OpenWeatherMapWeather weather = restTemplate.getForObject(url, OpenWeatherMapWeather.class);
        return openWeatherMapConverter.convert(weather);
    }
}
