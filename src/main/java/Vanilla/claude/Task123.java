package Vanilla.claude;

import java.util.*;

class Task123 {
    private Map<String, Session> sessions;

    public Task123() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(userId, sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public boolean validateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) return false;
        return !session.isExpired();
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private static class Session {
        private String userId;
        private String sessionId;
        private long creationTime;
        private static final long SESSION_TIMEOUT = 30 * 60 * 1000; // 30 minutes

        public Session(String userId, String sessionId) {
            this.userId = userId;
            this.sessionId = sessionId;
            this.creationTime = System.currentTimeMillis();
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - creationTime > SESSION_TIMEOUT;
        }
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        // Test Case 1: Create new session
        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Test 1 - Session Created: " + sessionId1);

        // Test Case 2: Validate valid session
        boolean isValid1 = sessionManager.validateSession(sessionId1);
        System.out.println("Test 2 - Session Valid: " + isValid1);

        // Test Case 3: End session
        sessionManager.endSession(sessionId1);
        boolean isValid2 = sessionManager.validateSession(sessionId1);
        System.out.println("Test 3 - Session Valid After End: " + isValid2);

        // Test Case 4: Validate invalid session
        boolean isValid3 = sessionManager.validateSession("invalid-session");
        System.out.println("Test 4 - Invalid Session Valid: " + isValid3);

        // Test Case 5: Create multiple sessions
        String sessionId2 = sessionManager.createSession("user2");
        String sessionId3 = sessionManager.createSession("user3");
        System.out.println("Test 5 - Multiple Sessions Created: " + 
            sessionManager.validateSession(sessionId2) + ", " + 
            sessionManager.validateSession(sessionId3));
    }
}
