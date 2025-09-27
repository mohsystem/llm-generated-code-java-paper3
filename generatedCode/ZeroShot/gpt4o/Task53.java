package ZeroShot.gpt4o;
import java.util.HashMap;
import java.util.UUID;

public class Task53 {
    private HashMap<String, String> sessionStore = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionStore.getOrDefault(sessionId, null);
    }

    public boolean destroySession(String sessionId) {
        return sessionStore.remove(sessionId) != null;
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        
        // Test Case 1
        String session1 = sessionManager.createSession("user1");
        System.out.println(sessionManager.getUserId(session1));

        // Test Case 2
        String session2 = sessionManager.createSession("user2");
        System.out.println(sessionManager.getUserId(session2));

        // Test Case 3
        System.out.println(sessionManager.getUserId("invalid_session"));

        // Test Case 4
        sessionManager.destroySession(session1);
        System.out.println(sessionManager.getUserId(session1));

        // Test Case 5
        System.out.println(sessionManager.destroySession(session2));
    }
}