package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AnotherWeakHash3rd {
    public static String hashMD5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
