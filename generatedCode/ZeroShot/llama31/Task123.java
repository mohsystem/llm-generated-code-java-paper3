package ZeroShot.llama31;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task123 {
    private static Map<String, Session> sessions = new HashMap<>();
    private static SecureRandom random = new SecureRandom();

    public static class Session {
        public String sessionId;
        public String userId;
        public long creationTime;
        public long expirationTime;

        public Session(String userId, long expirationTime) {
            this.sessionId = generateSessionId();
            this.userId = userId;
            this.creationTime = System.currentTimeMillis();
            this.expirationTime = creationTime + expirationTime;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expirationTime;
        }
    }

    public static String generateSessionId() {
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static String createSession(String userId, long expirationTime) {
        Session session = new Session(userId, expirationTime);
        sessions.put(session.sessionId, session);
        return session.sessionId;
    }

    public static void terminateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static boolean isSessionActive(String sessionId) {
        Session session = sessions.get(sessionId);
        return session != null && !session.isExpired();
    }

    public static void main(String[] args) {
        // Test cases
        String sessionId1 = createSession("user1", 3600000); // 1 hour
        String sessionId2 = createSession("user2", 1800000); // 30 minutes
        System.out.println("Session ID 1: " + sessionId1);
        System.out.println("Session ID 2: " + sessionId2);

        System.out.println("Is Session 1 active? " + isSessionActive(sessionId1));
        System.out.println("Is Session 2 active? " + isSessionActive(sessionId2));

        terminateSession(sessionId1);
        System.out.println("Is Session 1 active after termination? " + isSessionActive(sessionId1));
    }
}