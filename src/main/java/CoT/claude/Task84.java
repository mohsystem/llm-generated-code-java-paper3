package CoT.claude;

import java.util.UUID;

public class Task84 {
    public static String generateSessionId() {
        // Generate random UUID and convert to string
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            String sessionId = generateSessionId();
            System.out.println("Generated Session ID " + (i+1) + ": " + sessionId);
        }
    }
}
