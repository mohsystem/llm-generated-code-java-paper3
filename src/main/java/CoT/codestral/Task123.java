package CoT.codestral;
import java.util.*;

public class Task123 {
    private static Map<String, Session> sessions = new HashMap<>();

    public static void main(String[] args) {
        createSession("user1");
        createSession("user2");
        System.out.println(getSession("user1"));
        System.out.println(getSession("user2"));
        endSession("user1");
        System.out.println(getSession("user1"));
    }

    public static void createSession(String userId) {
        if (!sessions.containsKey(userId)) {
            sessions.put(userId, new Session(userId));
        }
    }

    public static Session getSession(String userId) {
        return sessions.get(userId);
    }

    public static void endSession(String userId) {
        sessions.remove(userId);
    }

    private static class Session {
        private String userId;
        private long createdAt;

        public Session(String userId) {
            this.userId = userId;
            this.createdAt = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return "Session{" +
                    "userId='" + userId + '\'' +
                    ", createdAt=" + createdAt +
                    '}';
        }
    }
}