package com.enigmacamp.exception;

public class GoodsNotSimilarToWarehouse extends  RuntimeException{
    public GoodsNotSimilarToWarehouse(){
        super("Goods not similar to warehouse");
    }
}
