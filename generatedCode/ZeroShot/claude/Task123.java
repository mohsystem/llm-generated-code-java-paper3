package ZeroShot.claude;

import java.util.*;
import java.security.*;
import java.time.Instant;

class Task123 {
    private static Map<String, Session> sessions = new HashMap<>();
    private static final int SESSION_TIMEOUT_MINS = 30;
    
    static class Session {
        private String sessionId;
        private String userId;
        private Instant lastAccessTime;
        private boolean isValid;
        
        public Session(String userId) {
            this.userId = userId;
            this.lastAccessTime = Instant.now();
            this.isValid = true;
            try {
                this.sessionId = generateSessionId();
            } catch (NoSuchAlgorithmException e) {
                this.sessionId = UUID.randomUUID().toString();
            }
        }
        
        private String generateSessionId() throws NoSuchAlgorithmException {
            SecureRandom sr = SecureRandom.getInstanceStrong();
            byte[] bytes = new byte[32];
            sr.nextBytes(bytes);
            return Base64.getEncoder().encodeToString(bytes);
        }
    }
    
    public static String createSession(String userId) {
        if(userId == null || userId.trim().isEmpty()) {
            return null;
        }
        
        Session session = new Session(userId);
        sessions.put(session.sessionId, session);
        return session.sessionId;
    }
    
    public static boolean validateSession(String sessionId) {
        if(sessionId == null || !sessions.containsKey(sessionId)) {
            return false;
        }
        
        Session session = sessions.get(sessionId);
        if(!session.isValid) {
            return false;
        }
        
        Instant now = Instant.now();
        if(now.isAfter(session.lastAccessTime.plusSeconds(SESSION_TIMEOUT_MINS * 60))) {
            invalidateSession(sessionId);
            return false;
        }
        
        session.lastAccessTime = now;
        return true;
    }
    
    public static void invalidateSession(String sessionId) {
        if(sessions.containsKey(sessionId)) {
            Session session = sessions.get(sessionId);
            session.isValid = false;
            sessions.remove(sessionId);
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: Create valid session
        String sessionId1 = createSession("user123");
        System.out.println("Test 1: " + (sessionId1 != null && validateSession(sessionId1)));
        
        // Test Case 2: Invalid session id
        System.out.println("Test 2: " + (!validateSession("invalid_session")));
        
        // Test Case 3: Null session id
        System.out.println("Test 3: " + (!validateSession(null)));
        
        // Test Case 4: Invalidate session
        String sessionId2 = createSession("user456");
        invalidateSession(sessionId2);
        System.out.println("Test 4: " + (!validateSession(sessionId2)));
        
        // Test Case 5: Empty user id
        System.out.println("Test 5: " + (createSession("") == null));
    }
}
