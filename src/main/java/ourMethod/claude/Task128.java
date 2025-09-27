package ourMethod.claude;

import java.security.SecureRandom;

public class Task128 {
    // Generate secure random number within specified range
    public static int generateSecureRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(max - min) + min;
    }
    
    // Generate secure random token of specified length
    public static String generateSecureToken(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder token = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(chars.length());
            token.append(chars.charAt(index));
        }
        return token.toString();
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Generate random number
            System.out.println("Random number between 1-100: " + generateSecureRandomNumber(1, 100));
            
            // Test case 2: Generate another random number 
            System.out.println("Random number between 50-150: " + generateSecureRandomNumber(50, 150));
            
            // Test case 3: Generate random token
            System.out.println("Random token (16 chars): " + generateSecureToken(16));
            
            // Test case 4: Generate another random token
            System.out.println("Random token (32 chars): " + generateSecureToken(32));
            
            // Test case 5: Test invalid input
            System.out.println("Invalid range test: " + generateSecureRandomNumber(100, 50));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
