package ourMethod.openai;
import java.util.HashMap;
import java.util.UUID;

public class Task43 {
    private HashMap<String, String> sessionStore;

    public Task43() {
        sessionStore = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void terminateSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public static void main(String[] args) {
        Task43 sessionManager = new Task43();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");
        String session3 = sessionManager.createSession("user3");
        String session4 = sessionManager.createSession("user4");
        String session5 = sessionManager.createSession("user5");

        System.out.println("Session1 userId: " + sessionManager.getUserId(session1));
        System.out.println("Session2 userId: " + sessionManager.getUserId(session2));
        System.out.println("Session3 userId: " + sessionManager.getUserId(session3));

        sessionManager.terminateSession(session1);
        System.out.println("Session1 userId after termination: " + sessionManager.getUserId(session1));

        sessionManager.terminateSession(session2);
        System.out.println("Session2 userId after termination: " + sessionManager.getUserId(session2));
    }
}