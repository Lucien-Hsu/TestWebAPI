package com.example.testwebapi;

public class Earthquake {
    private double magnitude;
    private String location;
    private long unixTime;
    private String mUrl;

    Earthquake(double magnitude, String location, long unixTime, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.unixTime = unixTime;
        this.mUrl = url;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setTime(long unixTime) {
        this.unixTime = unixTime;
    }
}
