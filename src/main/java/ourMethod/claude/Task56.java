package ourMethod.claude;

import java.security.SecureRandom;
import java.util.Base64;
import java.time.Instant;

public class Task56 {
    private static final int TOKEN_LENGTH_BYTES = 32;
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static String generateToken() {
        byte[] randomBytes = new byte[TOKEN_LENGTH_BYTES];
        secureRandom.nextBytes(randomBytes);
        
        // Combine random bytes with timestamp
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        byte[] tokenBytes = new byte[randomBytes.length + timestamp.getBytes().length];
        System.arraycopy(randomBytes, 0, tokenBytes, 0, randomBytes.length);
        System.arraycopy(timestamp.getBytes(), 0, tokenBytes, randomBytes.length, timestamp.getBytes().length);
        
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    public static void main(String[] args) {
        // Test token generation 5 times
        for(int i = 0; i < 5; i++) {
            String token = generateToken();
            System.out.println("Generated Token " + (i+1) + ": " + token);
        }
    }
}
