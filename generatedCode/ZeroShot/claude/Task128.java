package ZeroShot.claude;

import java.security.SecureRandom;
import java.util.Base64;

public class Task128 {
    public static String generateRandomToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static int generateRandomNumber(int min, int max) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Random Tokens:");
        for(int i = 0; i < 5; i++) {
            System.out.println(generateRandomToken(16));
        }
        
        System.out.println("\\nRandom Numbers (1-100):");
        for(int i = 0; i < 5; i++) {
            System.out.println(generateRandomNumber(1, 100));
        }
    }
}
