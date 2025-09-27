package ZeroShot.claude;

import java.util.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Task53 {
    private static Map<String, Session> sessions = new HashMap<>();
    private static final int SESSION_TIMEOUT_MINUTES = 30;
    
    static class Session {
        private String sessionId;
        private String userId;
        private LocalDateTime lastAccessTime;
        private Map<String, Object> attributes;
        
        public Session(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
            this.lastAccessTime = LocalDateTime.now();
            this.attributes = new HashMap<>();
        }
        
        public void updateLastAccessTime() {
            this.lastAccessTime = LocalDateTime.now();
        }
        
        public boolean isExpired() {
            return ChronoUnit.MINUTES.between(lastAccessTime, LocalDateTime.now()) >= SESSION_TIMEOUT_MINUTES;
        }
    }
    
    public static String createSession(String userId) {
        if(userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        
        String sessionId = generateSessionId();
        Session session = new Session(sessionId, userId);
        sessions.put(sessionId, session);
        return sessionId;
    }
    
    private static String generateSessionId() {
        return UUID.randomUUID().toString();
    }
    
    public static boolean validateSession(String sessionId) {
        if(sessionId == null || !sessions.containsKey(sessionId)) {
            return false;
        }
        
        Session session = sessions.get(sessionId);
        if(session.isExpired()) {
            invalidateSession(sessionId);
            return false;
        }
        
        session.updateLastAccessTime();
        return true;
    }
    
    public static void invalidateSession(String sessionId) {
        if(sessionId != null) {
            sessions.remove(sessionId);
        }
    }
    
    public static void setAttribute(String sessionId, String key, Object value) {
        if(validateSession(sessionId) && key != null) {
            sessions.get(sessionId).attributes.put(key, value);
        }
    }
    
    public static Object getAttribute(String sessionId, String key) {
        if(validateSession(sessionId) && key != null) {
            return sessions.get(sessionId).attributes.get(key);
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Create and validate session
        String sessionId1 = createSession("user123");
        System.out.println("Session created: " + sessionId1);
        System.out.println("Session valid: " + validateSession(sessionId1));
        
        // Test Case 2: Set and get attribute
        setAttribute(sessionId1, "role", "admin");
        System.out.println("Attribute value: " + getAttribute(sessionId1, "role"));
        
        // Test Case 3: Invalid session
        System.out.println("Invalid session check: " + validateSession("invalid-session"));
        
        // Test Case 4: Session invalidation
        invalidateSession(sessionId1);
        System.out.println("Session after invalidation: " + validateSession(sessionId1));
        
        // Test Case 5: Null checks
        try {
            createSession(null);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught expected exception for null user");
        }
    }
}
