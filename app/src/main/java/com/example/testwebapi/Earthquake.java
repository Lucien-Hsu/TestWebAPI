package com.example.testwebapi;

public class Earthquake {
    double magnitude;
    String location;
    long unixTime;


    Earthquake(double magnitude, String location, long unixTime) {
        this.magnitude = magnitude;
        this.location = location;
        this.unixTime = unixTime;
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
