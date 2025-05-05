package org.example.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyOwnClassLoader extends ClassLoader
{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        try {
            System.out.println("We try to load the class from MyOwnClassLoader");
            //We have to convert the file into bytes array
            byte[] arr = getBytesFromFile(name);
            int length = arr.length;
            //We have to put those bytes into defineClass method
            Class<?> cl = defineClass(name, arr, 0, length);
            if(cl == null) throw new ClassNotFoundException(name);
            System.out.println("Class loaded");
            return cl;
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] getBytesFromFile(String filename) throws IOException {
        //It has to be compiled version - .class!
        //The class can be encrypted
        //We cen decrypt it here :)
        return Files.readAllBytes(Paths.get(filename+".class"));
    }
}
