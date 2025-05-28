package org.example.services;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.awt.*;
import java.io.*;
import java.security.*;
import java.util.Scanner;

public class EncryptionService {
    public void encryptForMe(String password) throws NoSuchPaddingException, NoSuchAlgorithmException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        //1. We have to decide what algorithm we want to use
        Cipher cipher = Cipher.getInstance("AES");
        //We want to encrypt the password
        int mode = Cipher.ENCRYPT_MODE;
        Key key = generateKey();
        //2. We have to initialize algorithm with appropriate mode and key
        cipher.init(mode, key);
        //3. We want get to know what is the size of the block for specific algorithm
        int blockSize = cipher.getBlockSize();
        //4. We have to prepare input data
        int offset = 0;
        byte[] inputData = new byte[blockSize];
        inputData = password.getBytes();
        //5. We have to prepare output container
        int outSize = cipher.getOutputSize(blockSize);
        byte[] outputData = new byte[outSize];
        //6. Now we can encrypt our data
        cipher.update(inputData, offset, blockSize, outputData);
        //7. In case there are any leftovers
        outputData = cipher.doFinal();
        System.out.println(new String(outputData));
    }
    public Key generateKey() throws NoSuchAlgorithmException {
        //1. We want to generate key for specific algorithm
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //2.
        SecureRandom secureRandom = new SecureRandom();
        //3. We want to initialize generation using specific key
        keyGenerator.init(secureRandom);
        //4. We generate an appropriate key
        return keyGenerator.generateKey();
    }
    public void encryptThePasswordToFile(String password, String keySeed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        int mode = Cipher.ENCRYPT_MODE;
        Key key = new SecretKeySpec(keySeed.getBytes(), "AES");
        cipher.init(mode, key);
        CipherOutputStream outData = new CipherOutputStream(new FileOutputStream("klucz.pass"), cipher);
        byte[] bytes = password.getBytes();
        int offset = 0;
        int size = bytes.length;
        outData.write(bytes, offset, size);
        outData.flush();
        //ATTENTION! Always remember to close the stream! Otherwise, not all bytes will be written to the file
        outData.close();
    }
    public void decryptThePasswordFromFile(String keySeed) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        int mode = Cipher.DECRYPT_MODE;
        Key key = new SecretKeySpec(keySeed.getBytes(), "AES");
        cipher.init(mode, key);
        CipherInputStream cipherInputStream = new CipherInputStream(new FileInputStream("klucz.pass"), cipher);
        String decryptedPassword = new String(cipherInputStream.readAllBytes());
        System.out.println("Decrypted password from the file = " +decryptedPassword);
    }
    public void encryptRSAForMe(String password) throws NoSuchAlgorithmException, IOException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException {
        //1. We want to generate the pair of the keys - public and private
        //We also want to use RSA algorithm
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
        int keySize = 512;
        //2. We create the keys based on algorithm
        keyPairGenerator.initialize(keySize, secureRandom);
        //3. We get the information about the key pair
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();
        //4. Now we have the pair of keys. We can save them
        ObjectOutputStream publicObjectOutStream = new ObjectOutputStream(new FileOutputStream("public.pass"));
        publicObjectOutStream.writeObject(publicKey);
        publicObjectOutStream.close();
        ObjectOutputStream privateObjectOutStream = new ObjectOutputStream(new FileOutputStream("private.pass"));
        privateObjectOutStream.writeObject(privateKey);
        privateObjectOutStream.close();
        //5. Now, we can encrypt (using public key) the password and ave it into file
        Cipher cipher = Cipher.getInstance("RSA");
        int mode = Cipher.ENCRYPT_MODE;
        cipher.init(mode, publicKey);
        CipherOutputStream outData = new CipherOutputStream(new FileOutputStream("kluczRSA.pass"), cipher);
        byte[] dataToEncrypt = password.getBytes();
        int offset = 0;
        int size = dataToEncrypt.length;
        outData.write(dataToEncrypt, offset, size);
        outData.flush();
        outData.close();
    }
    public void decryptRSAForMe() throws IOException, ClassNotFoundException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("private.pass"));
        Key privateKey = (Key) objectInputStream.readObject();
        Cipher cipher = Cipher.getInstance("RSA");
        int mode = Cipher.DECRYPT_MODE;
        cipher.init(mode, privateKey);
        CipherInputStream cipherInputStream = new CipherInputStream(new FileInputStream("kluczRSA.pass"), cipher);
        String decryptedPassword = new String(cipherInputStream.readAllBytes());
        System.out.println("Decrypted password from the file RSA = " +decryptedPassword);
    }
}
