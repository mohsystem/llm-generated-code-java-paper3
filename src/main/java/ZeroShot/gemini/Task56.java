package ZeroShot.gemini;
import java.security.SecureRandom;
import java.util.Base64;

class Task56 {

    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[32]; // Generate 32 bytes (256 bits)
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String token = generateToken();
            System.out.println("Generated Token " + (i + 1) + ": " + token);
        }
    }
}