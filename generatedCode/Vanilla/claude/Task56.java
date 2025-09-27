package Vanilla.claude;

import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {
    public static String generateToken(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: Token length 16 = " + generateToken(16));
        System.out.println("Test Case 2: Token length 24 = " + generateToken(24));
        System.out.println("Test Case 3: Token length 32 = " + generateToken(32));
        System.out.println("Test Case 4: Token length 48 = " + generateToken(48));
        System.out.println("Test Case 5: Token length 64 = " + generateToken(64));
    }
}
