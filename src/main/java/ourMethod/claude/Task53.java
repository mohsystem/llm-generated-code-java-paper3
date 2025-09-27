package ourMethod.claude;

import java.time.Duration;
import java.util.*;
import java.security.SecureRandom;
import java.time.Instant;

public class Task53 {
    private static final int SESSION_ID_LENGTH = 32;
    private static final int SESSION_TIMEOUT_MINUTES = 30;
    private static final int MAX_SESSIONS_PER_USER = 5;
    private static Map<String, Session> sessions = new HashMap<>();
    private static SecureRandom secureRandom = new SecureRandom();
    
    static class Session {
        private String sessionId;
        private String userId;
        private Instant creationTime;
        private Instant lastAccessTime;
        
        public Session(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
            this.creationTime = Instant.now();
            this.lastAccessTime = Instant.now();
        }
        
        public boolean isValid() {
            return Duration.between(lastAccessTime, Instant.now())
                   .toMinutes() < SESSION_TIMEOUT_MINUTES;
        }
        
        public void updateLastAccessTime() {
            this.lastAccessTime = Instant.now();
        }
    }
    
    public static String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        
        // Clean expired sessions first
        cleanExpiredSessions();
        
        // Check number of active sessions for this user
        long userSessionCount = sessions.values().stream()
            .filter(s -> s.userId.equals(userId) && s.isValid())
            .count();
            
        if (userSessionCount >= MAX_SESSIONS_PER_USER) {
            throw new IllegalStateException("Maximum session limit reached for user");
        }
        
        // Generate secure random session ID
        String sessionId = generateSecureSessionId();
        sessions.put(sessionId, new Session(sessionId, userId));
        return sessionId;
    }
    
    public static boolean validateSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            return false;
        }
        
        Session session = sessions.get(sessionId);
        if (session == null || !session.isValid()) {
            return false;
        }
        
        session.updateLastAccessTime();
        return true;
    }
    
    public static void invalidateSession(String sessionId) {
        if (sessionId != null) {
            sessions.remove(sessionId);
        }
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
    
    private static void cleanExpiredSessions() {
        sessions.entrySet().removeIf(entry -> !entry.getValue().isValid());
    }

    public static void main(String[] args) {
        // Test Case 1: Create new session
        String userId1 = "user123";
        String sessionId1 = createSession(userId1);
        System.out.println("Test 1 - New Session Created: " + sessionId1);
        
        // Test Case 2: Validate valid session
        boolean isValid = validateSession(sessionId1);
        System.out.println("Test 2 - Session Valid: " + isValid);
        
        // Test Case 3: Invalid session ID
        boolean isInvalidSessionValid = validateSession("invalid_session_id");
        System.out.println("Test 3 - Invalid Session Valid: " + isInvalidSessionValid);
        
        // Test Case 4: Invalidate session
        invalidateSession(sessionId1);
        boolean isValidAfterInvalidation = validateSession(sessionId1);
        System.out.println("Test 4 - Session Valid After Invalidation: " + isValidAfterInvalidation);
        
        // Test Case 5: Maximum sessions per user
        try {
            for (int i = 0; i <= MAX_SESSIONS_PER_USER; i++) {
                createSession(userId1);
            }
        } catch (IllegalStateException e) {
            System.out.println("Test 5 - Max Sessions Exceeded: " + e.getMessage());
        }
    }
}
