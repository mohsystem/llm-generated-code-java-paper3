package ourMethod.llama31;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class Task56 {
    public static void main(String[] args) {
        String token = generateToken();
        System.out.println("Generated Token: " + token);
    }

    public static String generateToken() {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        
        // Convert UUID to bytes
        byte[] uuidBytes = new byte[16];
        uuid.getMostSignificantBits(uuidBytes, 0);
        uuid.getLeastSignificantBits(uuidBytes, 8);

        // Use SecureRandom to add additional randomness
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        // Combine UUID and random bytes
        byte[] combinedBytes = new byte[32];
        System.arraycopy(uuidBytes, 0, combinedBytes, 0, 16);
        System.arraycopy(randomBytes, 0, combinedBytes, 16, 16);

        // Encode the combined bytes using Base64
        return Base64.getUrlEncoder().withoutPadding().encodeToString(combinedBytes);
    }
}