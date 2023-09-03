package com.aslihanhasar.medicaltourismapp.utils;

import java.security.SecureRandom;

public class UniqueNumberGeneratorUtils {
    public static String generateUniqueNumber() {
        int CODE_LENGTH = 8;
        SecureRandom secureRandom = new SecureRandom();
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder randomStringBuilder = new StringBuilder(CODE_LENGTH);
        while (randomStringBuilder.length() < CODE_LENGTH) {
            int randomCharIndex = secureRandom.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomCharIndex);
            randomStringBuilder.append(randomChar);
        }
        return randomStringBuilder.toString();
    }

      /*
    private String generateUniqueTicketNumber() {
        int CODE_LENGTH = 8;
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[CODE_LENGTH];
        secureRandom.nextBytes(randomBytes);
        return Base64.getEncoder().withoutPadding().encodeToString(randomBytes);
    }
     */

}
