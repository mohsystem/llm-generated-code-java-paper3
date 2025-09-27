package ZeroShot.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task53 {
    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        String sessionId = sessionManager.createSession("user123");
        System.out.println("User: " + sessionManager.getUserFromSession(sessionId));
        sessionManager.deleteSession(sessionId);
    }
}