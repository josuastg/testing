package com.enigma.reader;
import constant.FileConstant;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class FileReaderProcessorImplTest {

    private  BufferedReader reader;

    {
        try {
            reader = new BufferedReader(new FileReader(FileConstant.FILE_INPUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BufferedReader reader2;

    {
        try {
            reader2 = new BufferedReader(new FileReader(FileConstant.FILE_OUTPUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//

    @Test
    public void reader_line_one_should_return_expected_created_slot_6() throws IOException {
        String expectedString = "create_parking_lot 6";
        String actualString = reader.readLine();
        Assert.assertEquals(expectedString,actualString);
    }



    private String readFileOuput() throws IOException {
        String line ;
        StringBuilder outputFile = new StringBuilder();
        File file = new File(FileConstant.FILE_OUTPUT);
        BufferedReader  bufferedReader = new BufferedReader(new FileReader(file));
        while ((line = bufferedReader.readLine()) != null){
            outputFile.append(line);
            outputFile.append("\n");
        }
        return outputFile.toString();
    }


}