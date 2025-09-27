package ourMethod.claude;

// Task43.java
import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.*;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class Task43 {
    // Thread-safe session store
    private static final ConcurrentHashMap<String, UserSession> sessions = new ConcurrentHashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int SESSION_TIMEOUT_MINUTES = 30;
    
    // Session class to store user data
    private static class UserSession {
        private final String userId;
        private final Instant createdAt;
        private Instant lastAccessedAt;
        private final Map<String, Object> attributes;
        
        public UserSession(String userId) {
            this.userId = userId;
            this.createdAt = Instant.now();
            this.lastAccessedAt = Instant.now();
            this.attributes = new HashMap<>();
        }
        
        public boolean isExpired() {
            return lastAccessedAt.plusSeconds(SESSION_TIMEOUT_MINUTES * 60)
                   .isBefore(Instant.now());
        }
        
        public void updateLastAccessed() {
            this.lastAccessedAt = Instant.now();
        }
    }
    
    // Create new session
    public String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        
        // Generate secure random session ID
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        String sessionId = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        
        // Create and store session
        UserSession session = new UserSession(userId);
        sessions.put(sessionId, session);
        
        return sessionId;
    }
    
    // Get session data
    public Map<String, Object> getSessionData(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        
        UserSession session = sessions.get(sessionId);
        if (session == null || session.isExpired()) {
            return null;
        }
        
        session.updateLastAccessed();
        return new HashMap<>(session.attributes);
    }
    
    // Set session attribute
    public void setSessionAttribute(String sessionId, String key, Object value) {
        if (sessionId == null || key == null) {
            throw new IllegalArgumentException("Session ID and key cannot be null");
        }
        
        UserSession session = sessions.get(sessionId);
        if (session != null && !session.isExpired()) {
            session.attributes.put(key, value);
            session.updateLastAccessed();
        }
    }
    
    // Invalidate session
    public void invalidateSession(String sessionId) {
        if (sessionId != null) {
            sessions.remove(sessionId);
        }
    }
    
    // Clean expired sessions
    public void cleanExpiredSessions() {
        sessions.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }
    
    // Main method with test cases
    public static void main(String[] args) {
        Task43 sessionManager = new Task43();
        
        // Test case 1: Create session
        String sessionId1 = sessionManager.createSession("user123");
        System.out.println("Test 1 - Session created: " + (sessionId1 != null));
        
        // Test case 2: Set and get session attribute
        sessionManager.setSessionAttribute(sessionId1, "role", "admin");
        Map<String, Object> data = sessionManager.getSessionData(sessionId1);
        System.out.println("Test 2 - Session data retrieved: " + (data != null && "admin".equals(data.get("role"))));
        
        // Test case 3: Invalid session ID
        Map<String, Object> invalidData = sessionManager.getSessionData("invalid-session-id");
        System.out.println("Test 3 - Invalid session returns null: " + (invalidData == null));
        
        // Test case 4: Session invalidation
        sessionManager.invalidateSession(sessionId1);
        Map<String, Object> invalidatedData = sessionManager.getSessionData(sessionId1);
        System.out.println("Test 4 - Invalidated session returns null: " + (invalidatedData == null));
        
        // Test case 5: Multiple sessions
        String sessionId2 = sessionManager.createSession("user456");
        String sessionId3 = sessionManager.createSession("user789");
        System.out.println("Test 5 - Multiple sessions created: " + 
                          (sessionId2 != null && sessionId3 != null && !sessionId2.equals(sessionId3)));
    }
}
