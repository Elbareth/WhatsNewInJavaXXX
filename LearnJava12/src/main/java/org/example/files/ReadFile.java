package org.example.files;

import java.io.*;

public class ReadFile {
    public void read() throws IOException {
        InputStream inputStream = new FileInputStream("pliczek.txt");
        //Reading all bytes from the file
        byte[] bytes = inputStream.readAllBytes();
        for(int i = 0; i < bytes.length; i++)
        {
            System.out.print(bytes[i]+" ");
        }
        System.out.println(" ");
        inputStream.close();
    }
    public void copyToFile() throws IOException {
        InputStream inputStream = new FileInputStream("pliczek.txt");
        File file = new File("pliczek2.txt");
        file.createNewFile(); // create file if it not exists
        OutputStream outputStream = new FileOutputStream(file);
        inputStream.transferTo(outputStream); // move data from input to output
        inputStream.close();
        outputStream.close(); 
    }
}
