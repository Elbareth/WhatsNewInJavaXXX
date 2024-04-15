package org.example.files;

import java.io.*;

public class ReadByteFile {

    public void readFile()
    {
        try {
            InputStream inputStream = new FileInputStream("pliczek.txt");
            DataInput dataInput = new DataInputStream(inputStream);
            System.out.println(dataInput.readByte());
            System.out.println(dataInput.readChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile()
    {
        try {
            File file = new File("pliczek-bytes.txt");
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            DataOutput dataOutput = new DataOutputStream(outputStream);
            dataOutput.writeByte(126);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
