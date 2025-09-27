package CoT.claude;

import java.util.*;
import java.time.Instant;
import java.security.SecureRandom;

class Task123 {
    private static Map<String, UserSession> sessions = new HashMap<>();
    private static final int SESSION_TIMEOUT_SECONDS = 1800; // 30 minutes
    private static final SecureRandom secureRandom = new SecureRandom();
    
    static class UserSession {
        String userId;
        String sessionToken;
        Instant lastAccessTime;
        
        UserSession(String userId, String sessionToken) {
            this.userId = userId;
            this.sessionToken = sessionToken;
            this.lastAccessTime = Instant.now();
        }
    }
    
    public static String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        
        // Generate secure random session token
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        String sessionToken = Base64.getEncoder().encodeToString(randomBytes);
        
        UserSession session = new UserSession(userId, sessionToken);
        sessions.put(sessionToken, session);
        return sessionToken;
    }
    
    public static boolean validateSession(String sessionToken) {
        if (sessionToken == null || !sessions.containsKey(sessionToken)) {
            return false;
        }
        
        UserSession session = sessions.get(sessionToken);
        if (Instant.now().getEpochSecond() - session.lastAccessTime.getEpochSecond() > SESSION_TIMEOUT_SECONDS) {
            sessions.remove(sessionToken);
            return false;
        }
        
        session.lastAccessTime = Instant.now();
        return true;
    }
    
    public static void invalidateSession(String sessionToken) {
        if (sessionToken != null) {
            sessions.remove(sessionToken);
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: Create and validate session
        String sessionToken1 = createSession("user123");
        System.out.println("Test 1: " + validateSession(sessionToken1)); // Should print true
        
        // Test Case 2: Invalid session token
        System.out.println("Test 2: " + validateSession("invalid_token")); // Should print false
        
        // Test Case 3: Invalidate session
        invalidateSession(sessionToken1);
        System.out.println("Test 3: " + validateSession(sessionToken1)); // Should print false
        
        // Test Case 4: Multiple sessions
        String sessionToken2 = createSession("user456");
        String sessionToken3 = createSession("user789");
        System.out.println("Test 4: " + (validateSession(sessionToken2) && validateSession(sessionToken3))); // Should print true
        
        // Test Case 5: Null input handling
        try {
            createSession(null);
            System.out.println("Test 5: Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 5: Passed - Caught null input");
        }
    }
}
