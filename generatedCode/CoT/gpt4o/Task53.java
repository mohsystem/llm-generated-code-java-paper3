package CoT.openai;
import java.util.HashMap;
import java.util.UUID;

public class Task53 {
    private HashMap<String, String> sessions = new HashMap<>();

    // Create a new session for a user
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    // Retrieve a username by session ID
    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    // Invalidate a session
    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Test cases
    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        
        String session1 = sessionManager.createSession("user1");
        System.out.println(sessionManager.getUsername(session1)); // Should print "user1"
        
        String session2 = sessionManager.createSession("user2");
        System.out.println(sessionManager.getUsername(session2)); // Should print "user2"
        
        sessionManager.invalidateSession(session1);
        System.out.println(sessionManager.getUsername(session1)); // Should print null
        
        String session3 = sessionManager.createSession("user3");
        System.out.println(sessionManager.getUsername(session3)); // Should print "user3"
        
        sessionManager.invalidateSession(session2);
        System.out.println(sessionManager.getUsername(session2)); // Should print null
    }
}