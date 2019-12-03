package com.enigmacamp.dao;
import com.enigmacamp.constant.ActionCommand;
import com.enigmacamp.exception.GoodsNotFound;
import com.enigmacamp.exception.WarehouseCapacityFull;
import com.enigmacamp.exception.WarehouseNumberNotFound;
import com.enigmacamp.model.Goods;
import org.junit.Assert;
import org.junit.Test;

public class WarehouseDaoImplTest {

    @Test
    public void build_storage_should_be_return_rooms_created() {
        Integer room = 1;
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(room);
        String expectedResultString =String.format(ActionCommand.BUILD_STORAGE_ROOMS, room);
        String actualResultString= warehouseDao.build_storage();
        Assert.assertEquals(expectedResultString, actualResultString);
        System.out.println(expectedResultString);
        System.out.println(actualResultString);
    }
    @Test
    public void setStorageTest_should_return_message_success_set_storage(){
        Integer expectedStorage = 1;
        Integer capacity = 1;
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl();
        String expectGoods ="books, newspapers";
        Integer storage_number= 1;
        String expectedString = String.format(ActionCommand.SET_STORAGE,expectedStorage,capacity, expectGoods);
        String actualString = warehouseDao.setStorage(storage_number,1, "books","newspapers" );
        Assert.assertEquals(expectedString,actualString);
        System.out.println(expectedString);
        System.out.println(actualString);
    }
    @Test
    public void storeTest_should_be_return_goods_stored_to_a_room(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        warehouseDao.build_storage();
        warehouseDao.setStorage(1,50,"armors","weapons");
        Integer expectedAmountGoods = 30;
        String expectedNameGoods = "armors";
        Integer expectedRoom = 1;
        String expectedResultString = String.format(ActionCommand.STORE, expectedAmountGoods, expectedNameGoods,expectedRoom);
        String actualResultString = warehouseDao.store(1,"armors", 30);
        Assert.assertEquals(expectedResultString,actualResultString);
        System.out.println(expectedResultString);
        System.out.println(actualResultString);
    }
    @Test
    public void takeTest_should_be_return_take_stored_from_a_room(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        warehouseDao.build_storage();
        warehouseDao.setStorage(1,50,"armors","weapons");
        Integer expectedAmountGoods = 10;
        String expectedNameGoods = "armors";
        Integer expectedRoom = 1;
        String expectedResultString = String.format(ActionCommand.TAKE, expectedAmountGoods, expectedNameGoods,expectedRoom);
        warehouseDao.store(1,"armors", 30);
        String actualResultString = warehouseDao.take(1, "armors", 10);
        Assert.assertEquals(expectedResultString,actualResultString);
        System.out.println(expectedResultString);
        System.out.println(actualResultString);
    }


    @Test
    public void clearTest_should_be_return_clear_room(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        warehouseDao.build_storage();
        warehouseDao.setStorage(1,50,"armors","weapons");
        Integer expectedRoom = 1;
        String expectedResultString = String.format(ActionCommand.CLEAR, expectedRoom);
        warehouseDao.store(1,"armors", 30);
        String actualResultString = warehouseDao.clear(1);
        Assert.assertEquals(expectedResultString,actualResultString);
        System.out.println(expectedResultString);
        System.out.println(actualResultString);
    }
    @Test(expected = WarehouseNumberNotFound.class)
    public void clearTest_should_be_return_clear_room_when_room_is_not_found(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        warehouseDao.build_storage();
        warehouseDao.setStorage(1,50,"armors","weapons");
        warehouseDao.store(1,"armors", 30);
        warehouseDao.clear(2);
    }
    @Test(expected = WarehouseCapacityFull.class)
    public void capacityTest_should_be_return_storage_capacity_is_full_when_capacity_isLowerThan_goods_amount(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        warehouseDao.setStorage(1,50,"armors","weapons");
        warehouseDao.store(1,"armors", 30);
        warehouseDao.store(1, "armors", 60);

    }
    @Test(expected = GoodsNotFound.class)
    public void store_should_be_return_goods_not_found_when_storage_in_goods_different_with_store_goods(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        warehouseDao.setStorage(1,50,"armors","weapons");
        warehouseDao.store(1,"ammunitions", 30);

    }
    @Test
    public void reportTest_should_be_return_result_report(){
        WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl(1);
        StringBuilder sb = new StringBuilder();
        Integer capacity = 50;
        Integer remainingCapacity = 10;
        warehouseDao.setStorage(1,50,"armors");
        warehouseDao.store(1,"armors", 10);
        String expectedResultString = String.format(ActionCommand.HEADER_REPORT) + sb.append(String.format(ActionCommand.REPORT,remainingCapacity,capacity,"["+new Goods("armors", 10)+"]"));
        String actualResultString = warehouseDao.report();
        Assert.assertEquals(expectedResultString,actualResultString);
        System.out.println(expectedResultString);
        System.out.println(actualResultString);

    }






}