package ourMethod.claude;

import java.security.SecureRandom;

public class Task85 {
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static String generateRandomString(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative");
        }
        
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(generateRandomString(5));  
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(0));
    }
}
