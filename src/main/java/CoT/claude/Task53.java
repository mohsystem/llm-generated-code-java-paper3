package CoT.claude;

public class Task53 {
    private static final int MAX_SESSIONS = 1000;
    private static final int SESSION_TIMEOUT = 1800; // 30 minutes in seconds
    
    private static class Session {
        private String sessionId;
        private String userId;
        private long lastAccessTime;
        private boolean isValid;
        
        public Session(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
            this.lastAccessTime = System.currentTimeMillis();
            this.isValid = true;
        }
    }
    
    private Session[] sessions;
    private int sessionCount;
    
    public Task53() {
        sessions = new Session[MAX_SESSIONS];
        sessionCount = 0;
    }
    
    public String createSession(String userId) {
        if(sessionCount >= MAX_SESSIONS) {
            cleanupExpiredSessions();
        }
        
        if(sessionCount >= MAX_SESSIONS) {
            return null; // Cannot create new session
        }
        
        String sessionId = generateSessionId();
        Session session = new Session(sessionId, userId);
        sessions[sessionCount++] = session;
        return sessionId;
    }
    
    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }
    
    public boolean validateSession(String sessionId) {
        Session session = findSession(sessionId);
        if(session == null || !session.isValid) {
            return false;
        }
        
        if((System.currentTimeMillis() - session.lastAccessTime) / 1000 > SESSION_TIMEOUT) {
            session.isValid = false;
            return false;
        }
        
        session.lastAccessTime = System.currentTimeMillis();
        return true;
    }
    
    public void invalidateSession(String sessionId) {
        Session session = findSession(sessionId);
        if(session != null) {
            session.isValid = false;
        }
    }
    
    private Session findSession(String sessionId) {
        for(int i = 0; i < sessionCount; i++) {
            if(sessions[i].sessionId.equals(sessionId)) {
                return sessions[i];
            }
        }
        return null;
    }
    
    private void cleanupExpiredSessions() {
        int validCount = 0;
        for(int i = 0; i < sessionCount; i++) {
            if(sessions[i].isValid && 
               (System.currentTimeMillis() - sessions[i].lastAccessTime) / 1000 <= SESSION_TIMEOUT) {
                sessions[validCount++] = sessions[i];
            }
        }
        sessionCount = validCount;
    }
    
    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        
        // Test case 1: Create new session
        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Test 1 - New session created: " + (sessionId1 != null));
        
        // Test case 2: Validate valid session
        boolean isValid = sessionManager.validateSession(sessionId1);
        System.out.println("Test 2 - Session validation: " + isValid);
        
        // Test case 3: Invalidate session
        sessionManager.invalidateSession(sessionId1);
        isValid = sessionManager.validateSession(sessionId1);
        System.out.println("Test 3 - Invalid session check: " + !isValid);
        
        // Test case 4: Create multiple sessions
        String[] sessions = new String[5];
        boolean allCreated = true;
        for(int i = 0; i < 5; i++) {
            sessions[i] = sessionManager.createSession("user" + i);
            if(sessions[i] == null) allCreated = false;
        }
        System.out.println("Test 4 - Multiple sessions created: " + allCreated);
        
        // Test case 5: Validate expired session
        try {
            Thread.sleep(2000); // Wait 2 seconds
            isValid = sessionManager.validateSession(sessions[0]);
            System.out.println("Test 5 - Session still valid after 2s: " + isValid);
        } catch(InterruptedException e) {
            System.out.println("Test 5 failed due to interruption");
        }
    }
}
