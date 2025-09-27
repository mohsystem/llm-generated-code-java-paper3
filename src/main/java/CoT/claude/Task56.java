package CoT.claude;

import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {
    public static String generateToken(int length) {
        if(length <= 0) {
            throw new IllegalArgumentException("Token length must be positive");
        }
        
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[length];
        secureRandom.nextBytes(tokenBytes);
        
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
    
    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println("Test 1: " + generateToken(16));  // Standard token
            System.out.println("Test 2: " + generateToken(32));  // Longer token
            System.out.println("Test 3: " + generateToken(8));   // Shorter token
            System.out.println("Test 4: " + generateToken(24));  // Medium token
            System.out.println("Test 5: " + generateToken(48));  // Extra long token
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
