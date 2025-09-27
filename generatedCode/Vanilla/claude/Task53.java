package Vanilla.claude;

import java.util.*;

class Task53 {
    private Map<String, Session> sessions;
    private static final int SESSION_TIMEOUT = 30; // minutes
    
    static class Session {
        String userId;
        Date lastAccessed;
        Map<String, Object> data;
        
        Session(String userId) {
            this.userId = userId;
            this.lastAccessed = new Date();
            this.data = new HashMap<>();
        }
        
        boolean isExpired() {
            long diffMinutes = (new Date().getTime() - lastAccessed.getTime()) / (60 * 1000);
            return diffMinutes > SESSION_TIMEOUT;
        }
        
        void updateLastAccessed() {
            this.lastAccessed = new Date();
        }
    }
    
    public Task53() {
        sessions = new HashMap<>();
    }
    
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(userId));
        return sessionId;
    }
    
    public boolean isValidSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) return false;
        if (session.isExpired()) {
            sessions.remove(sessionId);
            return false;
        }
        session.updateLastAccessed();
        return true;
    }
    
    public void addSessionData(String sessionId, String key, Object value) {
        Session session = sessions.get(sessionId);
        if (session != null && !session.isExpired()) {
            session.data.put(key, value);
            session.updateLastAccessed();
        }
    }
    
    public Object getSessionData(String sessionId, String key) {
        Session session = sessions.get(sessionId);
        if (session != null && !session.isExpired()) {
            session.updateLastAccessed();
            return session.data.get(key);
        }
        return null;
    }
    
    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
    
    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        
        // Test case 1: Create new session
        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Test 1 - New session created: " + sessionId1);
        
        // Test case 2: Add and retrieve session data
        sessionManager.addSessionData(sessionId1, "role", "admin");
        System.out.println("Test 2 - Session data: " + sessionManager.getSessionData(sessionId1, "role"));
        
        // Test case 3: Validate session
        System.out.println("Test 3 - Session valid: " + sessionManager.isValidSession(sessionId1));
        
        // Test case 4: Invalid session
        System.out.println("Test 4 - Invalid session: " + sessionManager.isValidSession("invalid-session"));
        
        // Test case 5: Invalidate session
        sessionManager.invalidateSession(sessionId1);
        System.out.println("Test 5 - Session after invalidation: " + sessionManager.isValidSession(sessionId1));
    }
}
