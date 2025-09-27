package CoT.claude;

import java.security.SecureRandom;

public class Task128 {
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static int generateRandomNumber(int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return secureRandom.nextInt(max - min + 1) + min;
    }
    
    public static String generateRandomToken(int length) {
        if(length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder token = new StringBuilder();
        for(int i = 0; i < length; i++) {
            token.append(chars.charAt(secureRandom.nextInt(chars.length())));
        }
        return token.toString();
    }

    public static void main(String[] args) {
        // Test case 1: Generate random number between 1-100
        System.out.println("Random number (1-100): " + generateRandomNumber(1, 100));
        
        // Test case 2: Generate random number between -50 to 50
        System.out.println("Random number (-50-50): " + generateRandomNumber(-50, 50));
        
        // Test case 3: Generate 10 character token
        System.out.println("Random token (10 chars): " + generateRandomToken(10));
        
        // Test case 4: Generate 20 character token
        System.out.println("Random token (20 chars): " + generateRandomToken(20));
        
        // Test case 5: Generate 5 character token
        System.out.println("Random token (5 chars): " + generateRandomToken(5));
    }
}
