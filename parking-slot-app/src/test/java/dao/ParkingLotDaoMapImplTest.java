package dao;
import constant.MessageConstant;
import model.Car;
import org.junit.Assert;
import org.junit.Test;
public class ParkingLotDaoMapImplTest {

    @Test
    public void createParkingLot_should_return_car_can_parking() {
        Integer capacity = 5;
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(capacity);
        String expecteResultString = String.format(MessageConstant.CREATE_PARKING_LOT, capacity);
        String actual = parkingLotDaoMap.createParkingLot();
        Assert.assertEquals(expecteResultString, actual);
        System.out.println(actual);
        System.out.println(expecteResultString);

    }

    @Test
    public void park_should_return_message_park_success_when_park_isEmpty() {
        Integer capacity = 1;
        Integer expectedSlot = 1;
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(capacity);
        parkingLotDaoMap.createParkingLot();
        Car car = new Car("B 1234 JJ");
        String expectedResultString = String.format(MessageConstant.PARK_CAR, expectedSlot);
        String actualString = parkingLotDaoMap.park(car);
        Assert.assertEquals(expectedResultString, actualString);
    }


    @Test
    public void park_should_return_message_car_license_number_already_have_parked(){
        Integer capacity = 2;
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(capacity);
        parkingLotDaoMap.createParkingLot();
        Car firstCar = new Car("B 1234 JJ");
        Car secondCar = new Car("B 1234 JJ");
        parkingLotDaoMap.park(firstCar);
        String actualString = parkingLotDaoMap.park(secondCar);
        String expectedResultString = String.format(MessageConstant.LICENSE_NUMBER_DUPLICATE);
        Assert.assertEquals(expectedResultString,actualString);

    }


    @Test
    public void leave_should_return_message_leave_success_when_car_isExist() {
        Integer capacity = 1;
        Integer expectedSlot = 1;
        Integer expectedDuration = 2;
        Double expectedFee = 10d;
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(capacity);
        Car car = new Car("B 1234 JJ");
        String expectedResultString = String.format(MessageConstant.PARK_CAR_LEAVE, car.getLicenseNumber(), expectedSlot, expectedFee);
        parkingLotDaoMap.park(car);
        String actualResultString = parkingLotDaoMap.leave(car, expectedDuration);
        Assert.assertEquals(expectedResultString, actualResultString);

    }

    @Test
    public void leave_should_return_correct_slot_when_car_is_leave_park() {
        Integer capacity = 3;
        Integer expectedSlot = 3;
        Integer expectedDuration = 2;
        Double expectedFee = 10d;
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(capacity);
        Car firstcar = new Car("B 1234 JJ");
        Car secondCar = new Car("B 1345 EE");
        Car thirdCar = new Car("B 1245 CV");
        parkingLotDaoMap.park(firstcar);
        parkingLotDaoMap.park(secondCar);
        parkingLotDaoMap.park(thirdCar);
        String expectedResultString = String.format(MessageConstant.PARK_CAR_LEAVE, thirdCar.getLicenseNumber(), expectedSlot, expectedFee);
        String actualResultString = parkingLotDaoMap.leave(thirdCar, expectedDuration);
        Assert.assertEquals(expectedResultString, actualResultString);

    }

    @Test
    public void leave_should_return_car_not_found_when_carIsNotExist() {
        Integer expectedSlot = 1;
        Integer expectedDuration = 2;
        Double expectedFee = 10d;
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(1);
        Car car = new Car("B 1235 KO");
        Car unknownCar = new Car("B 9090 JO");
        parkingLotDaoMap.park(car);
        String expectedResult = String.format(MessageConstant.CAR_NOT_FOUND, unknownCar.getLicenseNumber(), expectedSlot, expectedFee);
        String actualResult = parkingLotDaoMap.leave(unknownCar, expectedDuration);
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void park_should_return_park_is_full() {
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(2);
        Car firstCar = new Car("B 1562 K");
        Car secondCar = new Car("B 1235 KO");
        Car thirdCar = new Car("B 6789 JA");
        parkingLotDaoMap.park(firstCar);
        parkingLotDaoMap.park(secondCar);
        String expectedResult = String.format(MessageConstant.PARKING_LOT_FULL);
        String actualResult = parkingLotDaoMap.park(thirdCar);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFeeTest_shouldReturn30_when2Hour() {
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(1);
        Double expectedFeeDuration = 20d;
        Double actualFeeDuration = parkingLotDaoMap.calculateFee(3);
        Assert.assertEquals(expectedFeeDuration, actualFeeDuration);
    }

    @Test
    public void calculateFeeTest_shouldReturn40_when5Hour() {
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(1);
        Double expectedFeeDuration = 40d;
        Double actualFeeDuration = parkingLotDaoMap.calculateFee(5);
        Assert.assertEquals(expectedFeeDuration, actualFeeDuration);
    }

    @Test
    public void getParkingStatusTest_should_return_desc_parking_lot_status() {
        ParkingLotDaoMapImpl parkingLotDaoMap = new ParkingLotDaoMapImpl(2);
        StringBuilder stringBuilder = new StringBuilder();
        Car firstCar = new Car("B 1456 JK");
        Car secondCar = new Car("B 1678 AK");
        Integer slot =1;
        Integer slot2 =2;
        parkingLotDaoMap.park(firstCar);
        parkingLotDaoMap.park(secondCar);
        String  expectedStringResult =
        String.format(MessageConstant.HEADER_STATUS) + String.format(MessageConstant.STATUS ,slot, firstCar.getLicenseNumber())
        + stringBuilder.append(String.format(MessageConstant.STATUS, slot2, secondCar.getLicenseNumber()));
        String actualStringResult = parkingLotDaoMap.getStatus();
        Assert.assertEquals(expectedStringResult, actualStringResult);
        System.out.println(expectedStringResult);
        System.out.println(actualStringResult);
    }

}