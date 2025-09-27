package ourMethod.gpt4o;
import java.util.HashMap;
import java.util.UUID;
import java.util.Map;

public class Task53 {

    private Map<String, String> sessionStore = new HashMap<>();
    
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        // Test cases
        String session1 = sessionManager.createSession("user1");
        System.out.println(sessionManager.getUserId(session1));
        System.out.println(sessionManager.isValidSession(session1));
        sessionManager.endSession(session1);
        System.out.println(sessionManager.isValidSession(session1));
        
        String session2 = sessionManager.createSession("user2");
        System.out.println(sessionManager.getUserId(session2));
        sessionManager.endSession(session2);
    }
}