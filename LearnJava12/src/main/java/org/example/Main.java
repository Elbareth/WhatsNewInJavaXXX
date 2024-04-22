package org.example;

import org.example.files.*;

import java.io.IOException;
import java.io.RandomAccessFile;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        ReadStringFile stringFile = new ReadStringFile();
        ReadByteFile byteFile = new ReadByteFile();
        ReadRandomAccessFile randomFile = new ReadRandomAccessFile();
        ReadZipFile zipFile = new ReadZipFile();
        ReadObjectFile objectFile = new ReadObjectFile();
        try {
            readFile.read();
            readFile.copyToFile();
            stringFile.writeToFile();
            stringFile.readFile();
            byteFile.readFile();
            byteFile.writeToFile();
            randomFile.readFile();
            randomFile.writeToFile();
            zipFile.readFile();
            zipFile.writeToFile();
            objectFile.writeToFile();
            objectFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}