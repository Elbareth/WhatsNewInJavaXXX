package org.example.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadStringFile {
    public void readFile()
    {
        try {
            InputStream inputStreamReader = new FileInputStream("pliczek.txt");
            Scanner scanner = new Scanner(inputStreamReader);
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeToFile()
    {
        File file = new File("pliczek_string.txt");
        OutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("Dodatkowa linijka");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
