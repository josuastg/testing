package com.enigmacamp.model;


import java.util.Objects;

public class Goods {
    private String name;

    private Integer amount;
    public Goods() {
    }

    public Goods(String name) {
        this.name = name;
    }

    public Goods(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(getName(), goods.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        String result  = name + "(" + amount + ")";
        return result;
    }

}
