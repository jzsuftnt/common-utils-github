package com.example;

import java.util.Random;

public class WeakPRNG {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        int accountID = random.nextInt();

        System.out.println("Random Number: " + accountID);
    }
}