package ourMethod.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task123 {

    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        // Test cases
        String session1 = sessionManager.createSession("user1");
        System.out.println(sessionManager.getUserId(session1).equals("user1"));

        String session2 = sessionManager.createSession("user2");
        System.out.println(sessionManager.getUserId(session2).equals("user2"));

        sessionManager.removeSession(session1);
        System.out.println(sessionManager.getUserId(session1) == null);

        String session3 = sessionManager.createSession("user3");
        System.out.println(sessionManager.getUserId(session3).equals("user3"));

        sessionManager.removeSession(session2);
        System.out.println(sessionManager.getUserId(session2) == null);
    }
}