package Vanilla.openai;
import java.util.HashMap;
import java.util.Map;

public class Task53 {

    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = "session" + userId.hashCode();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task53 manager = new Task53();
        String session1 = manager.createSession("user1");
        String session2 = manager.createSession("user2");
        String session3 = manager.createSession("user3");
        String session4 = manager.createSession("user4");
        String session5 = manager.createSession("user5");

        System.out.println(manager.getUserId(session1)); // user1
        System.out.println(manager.getUserId(session2)); // user2
        System.out.println(manager.getUserId(session3)); // user3
        System.out.println(manager.getUserId(session4)); // user4
        System.out.println(manager.getUserId(session5)); // user5

        manager.endSession(session3);

        System.out.println(manager.getUserId(session3)); // null
    }
}