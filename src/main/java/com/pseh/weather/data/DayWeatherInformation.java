package com.pseh.weather.data;

import java.util.List;

public class DayWeatherInformation {
    private final List<DateTimeWeatherInformation> dateTimeWeatherInformationList;

    public DayWeatherInformation(List<DateTimeWeatherInformation> dateTimeWeatherInformationList) {
        this.dateTimeWeatherInformationList = dateTimeWeatherInformationList;
    }
}
