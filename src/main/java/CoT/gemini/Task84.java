package CoT.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class Task84 {

    public static String generateSessionId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[32]; // Generate 32 bytes of random data
        secureRandom.nextBytes(randomBytes);
        String sessionId = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        return sessionId;
    }

    public static void main(String[] args) {
        Set<String> sessionIds = new HashSet<>();
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