package ourMethod.claude;

import java.security.SecureRandom;
import java.util.Base64;

public class Task84 {
    private static final int SESSION_ID_LENGTH = 32;
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static String generateSessionId() {
        byte[] randomBytes = new byte[SESSION_ID_LENGTH];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            String sessionId = generateSessionId();
            System.out.println("Generated Session ID " + (i+1) + ": " + sessionId);
        }
    }
}
