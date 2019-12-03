package com.enigma.reader;

import constant.CommandConstant;
import constant.FileConstant;
import dao.ParkingLotDao;
import dao.ParkingLotDaoMapImpl;
import model.Car;

import java.io.*;

public class FileReaderProcessorImpl implements FileReaderProcessor {

    private ParkingLotDao parkingLotDao;

    @Override
    public  void commandFile() {
        try {
            File fileReader = new File(FileConstant.FILE_INPUT);
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new FileReader(fileReader));
            FileReaderProcessorImpl fileReaderProcessor = new FileReaderProcessorImpl();
            fileReaderProcessor.readCommand(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void readCommand(BufferedReader readerLine) {
        while (true) {
            try {
                String sentence = readerLine.readLine();
                if (sentence == null)
                    break;
                String dataSentence[] = sentence.trim().split("\\s+");
                dataText(dataSentence);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void dataText(String[] checkData) {
        for (int i = 0; i < checkData.length; i++) {
            String key = checkData[i].toUpperCase();
            switch (key) {
                case CommandConstant.CREATE_PARKING_LOT:
                    Integer slot = Integer.parseInt(checkData[i + 1]);
                    parkingLotDao = new ParkingLotDaoMapImpl(slot);
                    System.out.println(parkingLotDao.createParkingLot());
                    break;
                case CommandConstant.PARK:
                    System.out.println(parkingLotDao.park(new Car(checkData[i + 1])));
                    break;
                case CommandConstant.LEAVE:
                    Integer duration = Integer.parseInt(checkData[i + 2]);
                    System.out.println(parkingLotDao.leave(new Car(checkData[i + 1]), duration));
                    break;
                case CommandConstant.STATUS:
                    System.out.println(parkingLotDao.getStatus());
                    break;
                default:
                    break;
            }
        }


    }


}
