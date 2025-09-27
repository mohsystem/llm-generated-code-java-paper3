package ourMethod.claude;

import java.util.*;
import java.time.Instant;
import java.security.SecureRandom;

public class Task123 {
    private static final int SESSION_TIMEOUT_SECONDS = 1800; // 30 minutes
    private static final int SESSION_ID_LENGTH = 32;
    private Map<String, UserSession> sessions;
    private final SecureRandom secureRandom;
    
    public Task123() {
        this.sessions = new HashMap<>();
        this.secureRandom = new SecureRandom();
    }
    
    public static class UserSession {
        private final String userId;
        private final String sessionId;
        private final Instant creationTime;
        private Instant lastAccessTime;
        
        public UserSession(String userId, String sessionId) {
            this.userId = userId;
            this.sessionId = sessionId;
            this.creationTime = Instant.now();
            this.lastAccessTime = Instant.now();
        }
    }
    
    public String createSession(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        
        // Generate secure random session ID
        String sessionId = generateSecureSessionId();
        
        // Remove any existing session for this user
        removeExistingUserSessions(userId);
        
        // Create new session
        UserSession session = new UserSession(userId, sessionId);
        sessions.put(sessionId, session);
        
        return sessionId;
    }
    
    private String generateSecureSessionId() {
        byte[] randomBytes = new byte[SESSION_ID_LENGTH];
        secureRandom.nextBytes(randomBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : randomBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public boolean validateSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            return false;
        }
        
        UserSession session = sessions.get(sessionId);
        if (session == null) {
            return false;
        }
        
        // Check if session has expired
        if (isSessionExpired(session)) {
            invalidateSession(sessionId);
            return false;
        }
        
        // Update last access time
        session.lastAccessTime = Instant.now();
        return true;
    }
    
    private boolean isSessionExpired(UserSession session) {
        Instant now = Instant.now();
        return now.isAfter(session.lastAccessTime.plusSeconds(SESSION_TIMEOUT_SECONDS));
    }
    
    public void invalidateSession(String sessionId) {
        if (sessionId != null) {
            sessions.remove(sessionId);
        }
    }
    
    private void removeExistingUserSessions(String userId) {
        sessions.entrySet().removeIf(entry -> 
            entry.getValue().userId.equals(userId));
    }
    
    public static void main(String[] args) {
        // Test cases
        Task123 sessionManager = new Task123();
        
        // Test case 1: Create new session
        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Test 1 - New session created: " + (sessionId1 != null));
        
        // Test case 2: Validate valid session
        boolean isValid = sessionManager.validateSession(sessionId1);
        System.out.println("Test 2 - Session validation: " + isValid);
        
        // Test case 3: Validate invalid session
        boolean isInvalid = sessionManager.validateSession("invalid_session_id");
        System.out.println("Test 3 - Invalid session validation: " + !isInvalid);
        
        // Test case 4: Invalidate session
        sessionManager.invalidateSession(sessionId1);
        boolean isInvalidated = !sessionManager.validateSession(sessionId1);
        System.out.println("Test 4 - Session invalidation: " + isInvalidated);
        
        // Test case 5: Create session for same user
        String sessionId2 = sessionManager.createSession("user1");
        String sessionId3 = sessionManager.createSession("user1");
        boolean oldSessionInvalid = !sessionManager.validateSession(sessionId2);
        boolean newSessionValid = sessionManager.validateSession(sessionId3);
        System.out.println("Test 5 - Session replacement: " + (oldSessionInvalid && newSessionValid));
    }
}
