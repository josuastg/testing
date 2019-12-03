package com.enigmacamp.dao;

import com.enigmacamp.constant.ActionCommand;
import com.enigmacamp.exception.GoodsNotFound;
import com.enigmacamp.exception.WarehouseCapacityFull;
import com.enigmacamp.exception.WarehouseNumberNotFound;
import com.enigmacamp.model.Goods;
import com.enigmacamp.model.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseDaoImpl implements WarehouseDao {
    private Map<Integer, Storage> buildStorage = new HashMap<>();

    private Integer rooms;
    private Integer amount;

    public WarehouseDaoImpl() {
        this.amount = 0;
    }


    public WarehouseDaoImpl(Integer rooms) {
        this.rooms = rooms;
    }

    @Override
    public String build_storage() {
        for (int rooms = 1; rooms <= this.rooms; rooms++) {
            this.buildStorage.put(rooms, null);
        }

        return String.format(ActionCommand.BUILD_STORAGE_ROOMS, this.rooms);

    }

    @Override
    public String setStorage(Integer storageNumber, Integer capacity, String... types) {
        StringBuilder sb = new StringBuilder();
        List<Goods> list = new ArrayList<>();
        for (String type : types) {
            list.add(new Goods(type, 0));
        }
        buildStorage.put(storageNumber, new Storage(0, capacity, list));
        for (int i = 0; i < types.length; i++) {
            if (i == types.length - 1) {
                sb.append(types[i]);
            } else {
                sb.append(types[i]).append(", ");
            }
        }
        return String.format(ActionCommand.SET_STORAGE, storageNumber, capacity, sb);

    }

    public void warehouseNotFound(Integer rooms) {
        if (!buildStorage.containsKey(rooms)) {
            throw new WarehouseNumberNotFound(rooms);
        }
    }

    @Override
    public String store(Integer room, String goods, Integer amount) {
        warehouseNotFound(room);
        Storage storage = buildStorage.get(room);
        if (!storage.getTypeGoods().contains(new Goods(goods))) {
            throw new GoodsNotFound(goods, room);
            //validation if goods not found
        }
        Integer temporaryAmount = amount + storage.getRemaining_capacity();
        if (temporaryAmount > storage.getCapacity()) {
            throw new WarehouseCapacityFull(amount, goods, room);
            //validation if storage is full
        }
        for (int i = 0; i < storage.getTypeGoods().size(); i++) {
            if (storage.getTypeGoods().get(i).equals(new Goods(goods))) {
                storage.getTypeGoods().get(i).setAmount(storage.getTypeGoods().get(i).getAmount() + amount);
            }
        }
        storage.setRemaining_capacity(storage.getRemaining_capacity() + amount);
//        System.out.println(storage.getRemaining_capacity());
        System.out.println(storage.getTypeGoods());
        return String.format(ActionCommand.STORE, amount, goods, room);
    }

    @Override
    public String take(Integer room, String goods, Integer amount) {
        warehouseNotFound(room);
        Storage storage = buildStorage.get(room);
        if (!storage.getTypeGoods().contains(new Goods(goods))) {
            throw new GoodsNotFound(goods, room);
            //validation if goods not found
        }
        for (int i = 0; i < storage.getTypeGoods().size(); i++) {
            if (storage.getTypeGoods().get(i).equals(new Goods(goods))) {
                storage.getTypeGoods().get(i).setAmount(storage.getTypeGoods().get(i).getAmount() - amount);
            }
        }
        storage.setRemaining_capacity(storage.getRemaining_capacity() - amount);
        return String.format(ActionCommand.TAKE, amount, goods, room);
    }

    @Override
    public String clear(Integer room) {
        warehouseNotFound(room);
        for (Map.Entry<Integer, Storage> clearRooms : buildStorage.entrySet()) {
            if (clearRooms.getKey() != null) {
                if (clearRooms.getKey().equals(room)) {
                    this.buildStorage.put(clearRooms.getKey(), null);
                    return String.format(ActionCommand.CLEAR, room);

                }
            }


        }
        throw new WarehouseNumberNotFound(room);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(ActionCommand.HEADER_REPORT);
        for(Map.Entry<Integer,Storage> reports : this.buildStorage.entrySet()){
            if(reports.getKey() != null){
                if(reports.getValue() != null ){
                sb.append(String.format(ActionCommand.REPORT, reports.getValue().getRemaining_capacity(), reports.getValue().getCapacity(), reports.getValue().getTypeGoods()));
                }
            }

        }

    return  sb.toString();
    }

}
