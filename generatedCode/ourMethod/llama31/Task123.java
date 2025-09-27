package ourMethod.llama31;
import java.util.HashMap;
import java.util.Map;

public class Task123 {
    private static Map<String, Session> sessions = new HashMap<>();

    public static class Session {
        private String username;
        private long creationTime;

        public Session(String username) {
            this.username = username;
            this.creationTime = System.currentTimeMillis();
        }

        public String getUsername() {
            return username;
        }

        public long getCreationTime() {
            return creationTime;
        }
    }

    public static String createSession(String username) {
        Session session = new Session(username);
        String sessionId = java.util.UUID.randomUUID().toString();
        sessions.put(sessionId, session);
        return sessionId;
    }

    public static Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        String sessionId1 = createSession("user1");
        String sessionId2 = createSession("user2");

        Session session1 = getSession(sessionId1);
        System.out.println("User: " + session1.getUsername() + ", Created: " + session1.getCreationTime());

        invalidateSession(sessionId1);
        System.out.println("Session " + sessionId1 + " invalidated");

        // Test cases
        System.out.println(getSession(sessionId1)); // Should be null
        System.out.println(getSession(sessionId2).getUsername()); // Should be user2
    }
}