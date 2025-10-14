package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.UUID;

public class Task53 {

    private HashMap<String, String> sessionStore = new HashMap<>();

    // Start a new session for a user
    public String startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, username);
        return sessionId;
    }

    // Retrieve the username associated with a sessionId
    public String getUser(String sessionId) {
        return sessionStore.get(sessionId);
    }

    // End a session
    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    // Test cases
    public static void main(String[] args) {
        Task53 manager = new Task53();
        
        String sessionId1 = manager.startSession("user1");
        System.out.println("Session ID for user1: " + sessionId1);
        System.out.println("User for session ID " + sessionId1 + ": " + manager.getUser(sessionId1));
        
        String sessionId2 = manager.startSession("user2");
        System.out.println("Session ID for user2: " + sessionId2);
        System.out.println("User for session ID " + sessionId2 + ": " + manager.getUser(sessionId2));
        
        manager.endSession(sessionId1);
        System.out.println("User for session ID " + sessionId1 + " after ending session: " + manager.getUser(sessionId1));
        
        manager.endSession(sessionId2);
        System.out.println("User for session ID " + sessionId2 + " after ending session: " + manager.getUser(sessionId2));
        
        // Edge case: ending a session that does not exist
        manager.endSession("non-existent-session");
    }
}