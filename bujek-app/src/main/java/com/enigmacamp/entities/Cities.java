package com.enigmacamp.entities;

public class Cities {
    private String name;
    private Integer pointLocation;

    public Integer getPointLocation() {
        return pointLocation;
    }

    public void setPointLocation(Integer pointLocation) {
        this.pointLocation = pointLocation;

    }

    public Cities() {
    }

    public Cities(String name, Integer pointLocation) {
        this.name = name;
        this.pointLocation = pointLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
