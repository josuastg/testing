package com.enigmacamp;

import com.enigmacamp.dao.BujekDaoImpl;
import com.enigmacamp.entities.Cities;

public class MainApp {
    public static void main(String[] args) {
        BujekDaoImpl bujekDao = new BujekDaoImpl();
        Cities A = new Cities("A",0);
        Cities B = new Cities("B",3);
        Cities C = new Cities("C",13);
        Cities D = new Cities("A",21);
        String time = "20:01";
        String time2 = "15:00";
        String time3 = "08:00";

        System.out.println("Distance "+bujekDao.calculationDistance(A,B)+" km");
        System.out.println("Fee per km "+bujekDao.calculationFeePerDistance(time));
        System.out.println("Fee total "+bujekDao.calculationFeeBasedTime(A,B, time));

        System.out.println("");
        System.out.println("Distance "+bujekDao.calculationDistance(B,D)+" km");
        System.out.println("Fee per km "+bujekDao.calculationFeePerDistance(time2));
        System.out.println("Fee total "+bujekDao.calculationFeeBasedTime(B,D, time2));

        System.out.println("");
        System.out.println("Distance "+bujekDao.calculationDistance(D,A)+" km");
        System.out.println("Fee per km "+bujekDao.calculationFeePerDistance(time3));
        System.out.println("Fee total "+bujekDao.calculationFeeBasedTime(C,A, time3));




    }


}
