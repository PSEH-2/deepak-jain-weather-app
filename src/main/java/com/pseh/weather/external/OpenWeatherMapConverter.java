package com.pseh.weather.external;

import com.pseh.external.data.gen.List;
import com.pseh.external.data.gen.OpenWeatherMapWeather;
import com.pseh.weather.data.DateTimeWeatherInformation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class OpenWeatherMapConverter {

    public Map<LocalDateTime, DateTimeWeatherInformation> convert(OpenWeatherMapWeather weather) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Map<LocalDateTime, DateTimeWeatherInformation> weatherInformationByDateTimeMap = new TreeMap<>();
        for (List list : weather.getList()) {
            LocalDateTime dateDt = null;
            String date = list.getDtTxt();
            dateDt = LocalDateTime.parse(date, dateFormat);

            DateTimeWeatherInformation dateTimeWeatherInformation = new DateTimeWeatherInformation(dateDt,
                    list.getMain().getTempMax(), list.getMain().getTempMin(), "Rain".equalsIgnoreCase(list.getWeather().get(0).getMain()));


            weatherInformationByDateTimeMap.put(dateDt, dateTimeWeatherInformation);

        }
        return weatherInformationByDateTimeMap;
    }


}
