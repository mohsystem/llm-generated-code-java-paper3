package ZeroShot.claude;

import java.security.SecureRandom;

public class Task85 {
    public static String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHA.length());
            sb.append(ALPHA.charAt(randomIndex));
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println(generateRandomString(5));  // e.g. "KjHmN"
            System.out.println(generateRandomString(10)); // e.g. "pQrStUvWxY"
            System.out.println(generateRandomString(15)); // e.g. "aBcDeFgHiJkLmNo"
            System.out.println(generateRandomString(20)); // e.g. "MnOpQrStUvWxYzAbCdEf"
            System.out.println(generateRandomString(1));  // e.g. "X"
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
