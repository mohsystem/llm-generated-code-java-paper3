package CoT.claude;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Task43 {
    private static final int SESSION_ID_LENGTH = 32;
    private static final int SESSION_TIMEOUT_MINUTES = 30;
    private static Map<String, Session> sessions = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();

    static class Session {
        private String userId;
        private Instant createdAt;
        private Instant lastAccessedAt;

        public Session(String userId) {
            this.userId = userId;
            this.createdAt = Instant.now();
            this.lastAccessedAt = Instant.now();
        }

        public boolean isValid() {
            return lastAccessedAt.plusSeconds(SESSION_TIMEOUT_MINUTES * 60).isAfter(Instant.now());
        }

        public void updateLastAccessed() {
            this.lastAccessedAt = Instant.now();
        }
    }

    public static String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        String sessionId = generateSecureSessionId();
        sessions.put(sessionId, new Session(userId));
        return sessionId;
    }

    private static String generateSecureSessionId() {
        byte[] randomBytes = new byte[SESSION_ID_LENGTH];
        secureRandom.nextBytes(randomBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : randomBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean validateSession(String sessionId) {
        if (sessionId == null || !sessions.containsKey(sessionId)) {
            return false;
        }

        Session session = sessions.get(sessionId);
        if (!session.isValid()) {
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

    public static void main(String[] args) {
        // Test Case 1: Create and validate session
        String sessionId1 = createSession("user123");
        System.out.println("Test 1 - Session valid: " + validateSession(sessionId1));

        // Test Case 2: Invalid session ID
        System.out.println("Test 2 - Invalid session: " + validateSession("invalid_session_id"));

        // Test Case 3: Terminate session
        terminateSession(sessionId1);
        System.out.println("Test 3 - Terminated session valid: " + validateSession(sessionId1));

        // Test Case 4: Null user ID
        try {
            createSession(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 4 - Caught expected exception for null user ID");
        }

        // Test Case 5: Multiple sessions
        String sessionId2 = createSession("user456");
        String sessionId3 = createSession("user789");
        System.out.println("Test 5 - Multiple sessions valid: " + 
            (validateSession(sessionId2) && validateSession(sessionId3)));
    }
}
