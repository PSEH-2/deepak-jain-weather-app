package com.pseh.weather.external.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapGeoLocation {
    private double altitude;
    private double latitude;
    private double longitude;
    private String geobase;
    private long geobaseid;

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setGeobase(String geobase) {
        this.geobase = geobase;
    }

    public void setGeobaseid(long geobaseid) {
        this.geobaseid = geobaseid;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getGeobase() {
        return geobase;
    }

    public long getGeobaseid() {
        return geobaseid;
    }
}
