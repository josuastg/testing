package com.enigmacamp.dao;

import com.enigmacamp.entities.Cities;
import com.enigmacamp.entities.Customer;

import java.util.HashMap;
import java.util.Map;


public class BujekDaoImpl {
    private Map<Customer, Cities> bujekDaoMap = new HashMap<>();

    public Integer calculationDistance(Cities city1, Cities city2) {
        return distanceEachCities(city1, city2);

    }

    private Integer distanceEachCities(Cities city1, Cities city2) {
        if (city2.getPointLocation() > city1.getPointLocation()) {
            return city2.getPointLocation() - city1.getPointLocation();
        } else {
            return city1.getPointLocation() - city2.getPointLocation();
        }
    }

    public Integer calculationFeeBasedTime(Cities cities1, Cities cities2, String time) {

        return calculationDistance(cities1, cities2) * calculationFeePerDistance(time);

    }

    public Integer calculationFeePerDistance(String time) {
        String[] hour = time.split(":");
        Integer hours = Integer.valueOf(hour[0] + hour[1]);
        return CalculationHours(hours);
    }

    private Integer CalculationHours(Integer hours) {
        if (hours >= 0 && hours <= 600) {
            return 2000;
        } else if (hours > 600 && hours <= 900) {
            return 5000;
        } else if (hours > 900 && hours <= 1500) {
            return 3000;
        } else if (hours > 1500 && hours <= 2000) {
            return 6000;
        }

        return 2000;
    }

}


