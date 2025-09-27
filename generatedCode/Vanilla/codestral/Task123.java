package Vanilla.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task123 {
    private Map<String, String> sessions = new HashMap<>();

    public void startSession(String userId, String sessionId) {
        sessions.put(userId, sessionId);
    }

    public void endSession(String userId) {
        sessions.remove(userId);
    }

    public boolean isSessionActive(String userId) {
        return sessions.containsKey(userId);
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        // Test cases
        sessionManager.startSession("user1", "session1");
        System.out.println(sessionManager.isSessionActive("user1")); // true

        sessionManager.endSession("user1");
        System.out.println(sessionManager.isSessionActive("user1")); // false
    }
}