package org.example.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {
    public void createHash(String message) throws NoSuchAlgorithmException {
        //1. We choose what algorithm we are interested in
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        //2. We load our message into the algorithm
        messageDigest.update(message.getBytes());
        //3. We calculate the result based on the algorithm
        byte[] digest = messageDigest.digest();
        for(int i = 0; i < digest.length; i++)
        {
            System.out.print(digest[i]);
        }
        System.out.println("");
    }
}
