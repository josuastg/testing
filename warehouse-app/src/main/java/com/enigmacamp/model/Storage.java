package com.enigmacamp.model;

import java.util.List;

public class Storage {
    private Integer remaining_capacity;
    private Integer capacity;
    private List<Goods> typeGoods;


    public Storage(Integer capacity) {
        this.capacity = capacity;
    }

    public Storage(Integer remaining_capacity, Integer capacity, List<Goods> typeGoods) {
        this.remaining_capacity = remaining_capacity;
        this.capacity = capacity;
        this.typeGoods = typeGoods;
    }

    public Storage() {
    }

    public Integer getRemaining_capacity() {
        return remaining_capacity;
    }

    public void setRemaining_capacity(Integer remaining_capacity) {
        this.remaining_capacity = remaining_capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }


    public List<Goods> getTypeGoods() {
        return typeGoods;
    }

}
