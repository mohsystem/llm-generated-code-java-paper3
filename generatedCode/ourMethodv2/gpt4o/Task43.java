package ourMethodv2.gpt4o;
// Java code implementation
import java.util.*;

public class Task43 {
    private Map<String, String> sessionStore = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void terminateSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public static void main(String[] args) {
        Task43 sessionManager = new Task43();
        
        // Test cases
        String sessionId1 = sessionManager.createSession("user1");
        String sessionId2 = sessionManager.createSession("user2");
        
        System.out.println(sessionManager.getUserFromSession(sessionId1)); // Should print user1
        System.out.println(sessionManager.getUserFromSession(sessionId2)); // Should print user2
        
        sessionManager.terminateSession(sessionId1);
        System.out.println(sessionManager.getUserFromSession(sessionId1)); // Should print null
        
        String sessionId3 = sessionManager.createSession("user3");
        System.out.println(sessionManager.getUserFromSession(sessionId3)); // Should print user3
    }
}