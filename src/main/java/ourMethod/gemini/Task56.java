package ourMethod.gemini;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {

    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[32]; // Generate 32 bytes (256 bits)
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes); // Encode to URL-safe Base64
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: " + generateToken());
        System.out.println("Test case 2: " + generateToken());
        System.out.println("Test case 3: " + generateToken());
        System.out.println("Test case 4: " + generateToken());
        System.out.println("Test case 5: " + generateToken());

    }
}