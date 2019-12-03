package com.enigmacamp.exception;

import com.enigmacamp.constant.ExceptionCommand;

public class WarehouseCapacityFull extends RuntimeException {
    public  WarehouseCapacityFull(Integer amount, String goods, Integer room){
        super(String.format(ExceptionCommand.WAREHOUSE_CAPACITY_FULL, amount, goods, room));

    }
}
