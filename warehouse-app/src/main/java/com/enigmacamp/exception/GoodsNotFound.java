package com.enigmacamp.exception;

import com.enigmacamp.constant.ExceptionCommand;

public class GoodsNotFound extends  RuntimeException {

    public GoodsNotFound(String goods, Integer room){
        super(String.format(ExceptionCommand.GOODS_NOT_FOUND, goods,room));

    }
}
