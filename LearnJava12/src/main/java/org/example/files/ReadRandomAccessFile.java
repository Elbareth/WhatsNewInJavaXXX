package org.example.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadRandomAccessFile {

    public void readFile()
    {
        try {
            RandomAccessFile randomFile = new RandomAccessFile("pliczek.txt", "r");
            System.out.println("Current position of the index = " +randomFile.getFilePointer());
            System.out.println("Current value = " + randomFile.read());
            System.out.println("We move our pointer to anther position");
            randomFile.seek(7);
            System.out.println("Current position of the index = " +randomFile.getFilePointer());
            System.out.println("Current value = " + randomFile.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile()
    {
        try {
            //it will create the file if it doesn't exist
            RandomAccessFile randomFile = new RandomAccessFile("pliczek_randomFile.txt", "rw");
            System.out.println("Current position of the index = " +randomFile.getFilePointer());
            randomFile.writeByte(126);
            System.out.println("We move our pointer to anther position");
            randomFile.seek(1);
            System.out.println("Current position of the index = " +randomFile.getFilePointer());
            randomFile.writeByte(125);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
