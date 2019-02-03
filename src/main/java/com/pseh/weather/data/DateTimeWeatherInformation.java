package com.pseh.weather.data;

import java.time.LocalDateTime;

public class DateTimeWeatherInformation {
    private final LocalDateTime dateDt;
    private final double maxTemp;
    private final double minTemp;
    private final boolean willRain;

    public DateTimeWeatherInformation(LocalDateTime dateDt, double maxTemp, double minTemp, boolean willRain) {
        this.dateDt = dateDt;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.willRain = willRain;
    }

    public LocalDateTime getDateDt() {
        return dateDt;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public boolean getWillRain() {
        return willRain;
    }
}
