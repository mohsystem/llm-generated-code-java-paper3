package ZeroShot.claude;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Task43 {
    private static final int SESSION_ID_LENGTH = 32;
    private static final long SESSION_TIMEOUT_SECONDS = 1800; // 30 minutes
    private static Map<String, Session> sessions = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();

    static class Session {
        private String sessionId;
        private String userId;
        private Instant createdAt;
        private Instant lastAccessedAt;

        public Session(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
            this.createdAt = Instant.now();
            this.lastAccessedAt = Instant.now();
        }

        public boolean isValid() {
            return Duration.between(lastAccessedAt, Instant.now()).getSeconds() < SESSION_TIMEOUT_SECONDS;
        }

        public void updateLastAccessed() {
            this.lastAccessedAt = Instant.now();
        }
    }

    public static String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        byte[] randomBytes = new byte[SESSION_ID_LENGTH];
        secureRandom.nextBytes(randomBytes);
        String sessionId = bytesToHex(randomBytes);

        Session session = new Session(sessionId, userId);
        sessions.put(sessionId, session);
        
        return sessionId;
    }

    public static boolean validateSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            return false;
        }

        Session session = sessions.get(sessionId);
        if (session == null || !session.isValid()) {
            terminateSession(sessionId);
            return false;
        }

        session.updateLastAccessed();
        return true;
    }

    public static void terminateSession(String sessionId) {
        if (sessionId != null) {
            sessions.remove(sessionId);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Create new session
        String sessionId1 = createSession("user123");
        System.out.println("Test 1 - New Session Created: " + sessionId1);
        
        // Test Case 2: Validate valid session
        boolean isValid = validateSession(sessionId1);
        System.out.println("Test 2 - Session Valid: " + isValid);
        
        // Test Case 3: Validate invalid session
        boolean invalidSession = validateSession("invalid_session_id");
        System.out.println("Test 3 - Invalid Session: " + invalidSession);
        
        // Test Case 4: Terminate session
        terminateSession(sessionId1);
        boolean terminatedSession = validateSession(sessionId1);
        System.out.println("Test 4 - Terminated Session Valid: " + terminatedSession);
        
        // Test Case 5: Create and validate multiple sessions
        String sessionId2 = createSession("user456");
        String sessionId3 = createSession("user789");
        System.out.println("Test 5 - Multiple Sessions Valid: " + 
            (validateSession(sessionId2) && validateSession(sessionId3)));
    }
}
