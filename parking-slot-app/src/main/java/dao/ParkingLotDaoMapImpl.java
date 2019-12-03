package dao;

import constant.MessageConstant;
import model.Car;

import java.util.HashMap;
import java.util.Map;


public class ParkingLotDaoMapImpl implements ParkingLotDao {
    private Integer capacity;
    private static final Integer firstHours = 2;
    private static final Double feeFirstHours = 10d;
    private static final Double feeNextHour = 10d;
    public static final MessageConstant message = new MessageConstant();

    public ParkingLotDaoMapImpl(Integer capacity) {
        this.capacity = capacity;
    }

    private Map<Integer, Car> parkingSlots = new HashMap<>();

    @Override
    public String createParkingLot() {
        for (int slot = 0; slot <= this.capacity; slot++) {
            this.parkingSlots.put(slot, null);
        }
        return String.format(message.CREATE_PARKING_LOT, this.capacity);
    }

    @Override
    public String park(Car car) {
//        if (createParkingLot() == null)
//            return String.format(MessageConstant.PARKING_LOT_NOT_FOUND);
        if (parkingSlots.containsValue(car)) {
            return String.format(message.LICENSE_NUMBER_DUPLICATE);
        } else
            for (int slot = 1; slot <= this.capacity; slot++) {
                if (this.parkingSlots.get(slot) == null) {
                    this.parkingSlots.put(slot, car);
                    return String.format(message.PARK_CAR, slot);
                }
            }

        return String.format(message.PARKING_LOT_FULL);
    }

    @Override
    public String leave(Car car, Integer duration) {
        for (Map.Entry<Integer, Car> slots : parkingSlots.entrySet()) {
            if (slots.getValue() != null) {
                Car selectedCar = slots.getValue();
                if (selectedCar.getLicenseNumber().equals(car.getLicenseNumber())) {
                    this.parkingSlots.put(slots.getKey(), null);
                    return String.format(message.PARK_CAR_LEAVE, selectedCar.getLicenseNumber(), slots.getKey(), calculateFee(duration));
                }
            }
        }
//        for (int i = 1; i <= this.capacity; i++) {
//            if (this.parkingSlots.get(i) != null) {
//                if (this.parkingSlots.get(i).getLicenseNumber().equals(car.getLicenseNumber())) {
//                    this.parkingSlots.put(i, null);
//                    return String.format(MessageConstant.PARK_CAR_LEAVE, car.getLicenseNumber(), i, calculateFee(duration));
//
//                }
//
//
//            }
//
//        }
        return String.format(MessageConstant.CAR_NOT_FOUND, car.getLicenseNumber());
    }

    @Override
    public String getStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageConstant.HEADER_STATUS);
        for (Map.Entry<Integer, Car> slots : this.parkingSlots.entrySet()) {
            if (slots.getValue() != null) {
                stringBuilder.append(String.format(message.STATUS, slots.getKey(), slots.getValue().getLicenseNumber()));
            }
        }
        return stringBuilder.toString();
    }

    public Double calculateFee(Integer duration) {
        if (duration <= firstHours) {
            return feeFirstHours;
        }
        return feeFirstHours + ((duration - firstHours) * feeNextHour);
    }
}
