package Vanilla.claude;

import java.util.Random;

public class Task85 {
    public static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(generateRandomString(5));  // e.g. "kJheR"
        System.out.println(generateRandomString(10)); // e.g. "hGtRfVbNmK" 
        System.out.println(generateRandomString(3));  // e.g. "XyZ"
        System.out.println(generateRandomString(7));  // e.g. "AbCdEfG"
        System.out.println(generateRandomString(1));  // e.g. "Q"
    }
}
