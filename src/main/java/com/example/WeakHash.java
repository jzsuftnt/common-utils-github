package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WeakHash {
    public static String hashMD5(String data) throws NoSuchAlgorithmException {
        MessageDigest md1 = MessageDigest.getInstance("MD5");
        System.out.println("MessageDigest md1 = MessageDigest.getInstance(\"MD5\")");
        byte[] hashBytes = md1.digest(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
