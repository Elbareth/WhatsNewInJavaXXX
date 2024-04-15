package org.example.files;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ReadZipFile {

    public void readFile()
    {
        try{
            InputStream inputStream = new FileInputStream("pliczek.zip");
            ZipInputStream zipFile = new ZipInputStream(inputStream);
            ZipEntry zipEntry = null;
            while((zipEntry = zipFile.getNextEntry()) != null)
            {
                System.out.println(zipEntry.getName());
                System.out.println(zipEntry.getCreationTime());
                System.out.println(zipEntry.getSize());
                zipFile.closeEntry();
            }
            zipFile.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeToFile()
    {
        try{
            File file = new File("pliczek2.zip");
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            ZipOutputStream zipFile = new ZipOutputStream(outputStream);
            ZipEntry zipEntry = new ZipEntry("pliczek.txt");
            zipFile.putNextEntry(zipEntry);
            zipFile.closeEntry();
            zipFile.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
