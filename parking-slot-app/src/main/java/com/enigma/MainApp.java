package com.enigma;

import com.enigma.reader.FileReaderProcessorImpl;

public class MainApp {
    public static void main(String[] args) {
        FileReaderProcessorImpl fileReaderProcessor = new FileReaderProcessorImpl();
        fileReaderProcessor.commandFile();


    }
}
