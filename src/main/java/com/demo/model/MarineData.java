package com.demo.model;

public class MarineData {
    private Long id;
    private String location;
    private String temperature;

    public MarineData(Long id, String location, String temperature) {
        this.id = id;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
