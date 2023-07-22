package com.example.server.util;

import java.security.SecureRandom;

public class Uuid {
    private static final int UID_LENGTH = 10;
    private static final String DIGITS = "0123456789";

    public static String generateUniqueId() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(UID_LENGTH);

        for (int i = 0; i < UID_LENGTH; i++) {
            int index = random.nextInt(DIGITS.length());
            char randomDigit = DIGITS.charAt(index);
            sb.append(randomDigit);
        }

        return sb.toString();
    }
}
