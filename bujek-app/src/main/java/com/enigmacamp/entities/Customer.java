package com.enigmacamp.entities;

public class Customer {
    private String name;
    private Integer ID;

    public Customer() { }

    public Customer(String name, Integer ID) {
        this.name = name;
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
