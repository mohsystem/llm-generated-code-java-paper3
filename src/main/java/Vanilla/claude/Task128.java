package Vanilla.claude;

import java.util.Random;

public class Task128 {
    public static String generateToken(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder token = new StringBuilder();
        Random rnd = new Random();
        
        for(int i = 0; i < length; i++) {
            token.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return token.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        // Test case 1: Generate 8 character token
        System.out.println("Token (8 chars): " + generateToken(8));
        
        // Test case 2: Generate 12 character token
        System.out.println("Token (12 chars): " + generateToken(12));
        
        // Test case 3: Generate random number between 1-100
        System.out.println("Random number (1-100): " + generateRandomNumber(1, 100));
        
        // Test case 4: Generate random number between -50 to 50
        System.out.println("Random number (-50 to 50): " + generateRandomNumber(-50, 50));
        
        // Test case 5: Generate 16 character token
        System.out.println("Token (16 chars): " + generateToken(16));
    }
}
