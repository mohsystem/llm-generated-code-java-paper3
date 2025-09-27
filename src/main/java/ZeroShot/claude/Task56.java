package ZeroShot.claude;

import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {
    public static String generateToken(int length) {
        if (length < 1) return "";
        
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[length];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + generateToken(16));  // 16 byte token
        System.out.println("Test 2: " + generateToken(24));  // 24 byte token
        System.out.println("Test 3: " + generateToken(32));  // 32 byte token
        System.out.println("Test 4: " + generateToken(0));   // empty token
        System.out.println("Test 5: " + generateToken(8));   // 8 byte token
    }
}
