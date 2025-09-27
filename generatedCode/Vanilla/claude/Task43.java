package Vanilla.claude;

import java.util.*;
import java.time.LocalDateTime;
import java.security.SecureRandom;

class Task43 {
    private static Map<String, Session> sessions = new HashMap<>();
    private static final int SESSION_TIMEOUT_MINUTES = 30;
    
    static class Session {
        String sessionId;
        String userId;
        LocalDateTime lastAccessed;
        Map<String, Object> attributes;
        
        Session(String userId) {
            this.sessionId = generateSessionId();
            this.userId = userId;
            this.lastAccessed = LocalDateTime.now();
            this.attributes = new HashMap<>();
        }
        
        boolean isValid() {
            return LocalDateTime.now().minusMinutes(SESSION_TIMEOUT_MINUTES)
                   .isBefore(lastAccessed);
        }
    }
    
    private static String generateSessionId() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public static String createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(session.sessionId, session);
        return session.sessionId;
    }
    
    public static boolean validateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isValid()) {
            session.lastAccessed = LocalDateTime.now();
            return true;
        }
        if (session != null) {
            sessions.remove(sessionId);
        }
        return false;
    }
    
    public static void terminateSession(String sessionId) {
        sessions.remove(sessionId);
    }
    
    public static void main(String[] args) {
        // Test case 1: Create and validate session
        String sessionId1 = createSession("user1");
        System.out.println("Test 1 - Session valid: " + validateSession(sessionId1));
        
        // Test case 2: Terminate session
        terminateSession(sessionId1);
        System.out.println("Test 2 - Session valid after termination: " + validateSession(sessionId1));
        
        // Test case 3: Multiple sessions
        String sessionId2 = createSession("user2");
        String sessionId3 = createSession("user3");
        System.out.println("Test 3 - Multiple sessions valid: " + 
                          (validateSession(sessionId2) && validateSession(sessionId3)));
        
        // Test case 4: Invalid session
        System.out.println("Test 4 - Invalid session check: " + validateSession("invalid-session-id"));
        
        // Test case 5: Session timeout simulation
        String sessionId4 = createSession("user4");
        System.out.println("Test 5 - New session valid: " + validateSession(sessionId4));
    }
}
