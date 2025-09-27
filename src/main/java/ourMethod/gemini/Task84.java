package ourMethod.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class Task84 {

    public static String generateSessionId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[32]; // Use a sufficiently large byte array (e.g., 32 bytes)
        secureRandom.nextBytes(bytes);
        String sessionId = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        return sessionId;
    }


    public static void main(String[] args) {
        Set<String> sessionIds = new HashSet<>();

        // Test cases
        for (int i = 0; i < 5; i++) {
            String sessionId = generateSessionId();
            if (sessionIds.contains(sessionId)) {
                System.out.println("Error: Duplicate session ID generated.");
                return;
            }
            sessionIds.add(sessionId);
            System.out.println("Generated Session ID " + (i + 1) + ": " + sessionId);
        }

    }
}