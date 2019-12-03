package com.enigmacamp.exception;

import com.enigmacamp.constant.ExceptionCommand;

public class WarehouseNumberNotFound extends RuntimeException{
    public WarehouseNumberNotFound(Integer room ) {
        super(String.format(ExceptionCommand.WAREHOUSE_NUMBER_NOT_FOUND, room));
    }
}
