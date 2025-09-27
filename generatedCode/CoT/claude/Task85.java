package CoT.claude;

import java.security.SecureRandom;

public class Task85 {
    public static String generateRandomString(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative");
        }
        
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(letters.length());
            sb.append(letters.charAt(randomIndex));
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(25));
    }
}
