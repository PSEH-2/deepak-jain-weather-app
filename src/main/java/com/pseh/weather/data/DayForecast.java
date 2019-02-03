package com.pseh.weather.data;

import java.util.Objects;
import java.util.Set;

public class DayForecast {
    private final String date;
    private final String maxTemp;
    private final String minTemp;
    private final Set<String> messages;

    public DayForecast(String date, String maxTemp, String minTemp, Set<String> messages) {
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.messages = messages;
    }

    public String getDate() {
        return date;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public Set<String> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayForecast that = (DayForecast) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(maxTemp, that.maxTemp) &&
                Objects.equals(minTemp, that.minTemp) &&
                Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, maxTemp, minTemp, messages);
    }

    @Override
    public String toString() {
        return "DayForecast{" +
                "date='" + date + '\'' +
                ", maxTemp='" + maxTemp + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", messages=" + messages +
                '}';
    }
}
