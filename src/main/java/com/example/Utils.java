package com.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class Utils {

    // use unsafe DES algorithm for encryption
    public static String encryptDES(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Decrypt using unsafe DES algorithm
    public static String decryptDES(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    // Generate DES key
    public static SecretKey generateDESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        // DES key length is 56 bits
        keyGen.init(56);
        return keyGen.generateKey();
    }

    public static String generatePRNG() {
        Random random = new Random(System.currentTimeMillis());
        int accountID = random.nextInt();
        return String.valueOf(accountID);
    }

    public static String hashMD5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String data = "Sensitive Data";
            SecretKey key = generateDESKey();

            String encryptedData = encryptDES(data, key);
            System.out.println("Encrypted Data: " + encryptedData);

            String decryptedData = decryptDES(encryptedData, key);
            System.out.println("Decrypted Data: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}