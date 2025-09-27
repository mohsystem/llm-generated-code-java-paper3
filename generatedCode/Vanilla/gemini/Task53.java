package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Task53 {

    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();

        String sessionId1 = sessionManager.createSession("user1");
        String sessionId2 = sessionManager.createSession("user2");
        String sessionId3 = sessionManager.createSession("user3");

        System.out.println(sessionManager.getUsername(sessionId1)); // Output: user1
        System.out.println(sessionManager.getUsername(sessionId2)); // Output: user2
        System.out.println(sessionManager.getUsername(sessionId3)); // Output: user3

        sessionManager.invalidateSession(sessionId2);

        System.out.println(sessionManager.getUsername(sessionId2)); // Output: null
        System.out.println(sessionManager.getUsername(sessionId1)); // Output: user1


    }
}