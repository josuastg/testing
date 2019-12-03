package com.enigmacamp.entities;

public class Order {
    private Integer ID;
    private String destination;
    private Integer timeOrder;

    public Order(Integer ID, String destination, Integer timeOrder) {
        this.ID = ID;
        this.destination = destination;
        this.timeOrder = timeOrder;
    }

    public Order() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Integer timeOrder) {
        this.timeOrder = timeOrder;
    }
}
