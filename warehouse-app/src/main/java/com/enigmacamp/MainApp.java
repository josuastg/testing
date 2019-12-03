package com.enigmacamp;
import com.enigmacamp.dao.WarehouseDaoImpl;
import com.enigmacamp.model.Goods;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        WarehouseDaoImpl warehouseDao1 = new WarehouseDaoImpl(6);
        //create build storage
        System.out.println(warehouseDao1.build_storage());

        //create set storage
        List<Goods> goodsList = new ArrayList<>();
        Goods goods = new Goods("weapons",2);
        Goods goods1 = new Goods("ammunitions", 2);
        Goods goods2 = new Goods("armors", 1);
        goodsList.add(goods);
        goodsList.add(goods1);
        goodsList.add(goods2);
        Integer room = 1;
        Integer capacity = 50;
        System.out.println( warehouseDao1.setStorage(room,capacity,"weapons","armors", "ammunitions"));
        System.out.println( warehouseDao1.setStorage(2,50,"newspapers","magazine", "tabloids"));

        // store goods
        System.out.println(warehouseDao1.store(1, "armors", 10));
        System.out.println(warehouseDao1.store(1, "weapons", 10));
        warehouseDao1.store(1,"armors",20);
        System.out.println(warehouseDao1.store(1, "ammunitions", 10));
        warehouseDao1.store(2,"newspapers",20);
        warehouseDao1.store(2,"magazine",20);
        warehouseDao1.store(2,"tabloids",5);
        //take goods
        System.out.println(warehouseDao1.take(1, "armors", 10));
        //clear storage
//        System.out.println(warehouseDao1.clear(1));
        //report storage
        System.out.println(warehouseDao1.report());
//        System.out.println(warehouseDao1.clear(2));






    }
}
