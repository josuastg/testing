package com.enigmacamp.dao;

import com.enigmacamp.model.Storage;

public interface WarehouseDao  {
    public String build_storage();
    public String setStorage(Integer storage_number, Integer capacity, String... types);
    public String store (Integer room, String goods, Integer amount);
    public String take (Integer room, String goods, Integer amount);
    public String clear (Integer room);
    public String report();


}
