package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task123 {
    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");
        String session3 = sessionManager.createSession("user3");
        String session4 = sessionManager.createSession("user4");
        String session5 = sessionManager.createSession("user5");

        System.out.println(sessionManager.isSessionActive(session1)); // true
        System.out.println(sessionManager.isSessionActive(session2)); // true

        sessionManager.endSession(session1);

        System.out.println(sessionManager.isSessionActive(session1)); // false
        System.out.println(sessionManager.getUsername(session2)); // user2
    }
}