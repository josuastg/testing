package com.enigmacamp.exception;

public class GoodsNotEnough extends  RuntimeException {
    public GoodsNotEnough(){
        super("goods not found");
    }
}
