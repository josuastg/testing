package com.enigma.reader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReaderProcessor {
    public void readCommand (BufferedReader readerLine) throws IOException;
    public  void commandFile () throws FileNotFoundException;
    public void dataText(String [] checkData);
}
