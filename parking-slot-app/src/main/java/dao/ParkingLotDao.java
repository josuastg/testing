package dao;

import model.Car;

public interface ParkingLotDao {

    public String createParkingLot();
    public String park (Car car);
    public String leave (Car car, Integer duration);
    public String getStatus();
}
