package ourMethod.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task53 {

    private Map<String, Session> sessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(username);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();

        // Test cases
        String sessionId1 = sessionManager.createSession("user1");
        Session session1 = sessionManager.getSession(sessionId1);
        System.out.println("Session 1: " + session1);

        String sessionId2 = sessionManager.createSession("user2");
        Session session2 = sessionManager.getSession(sessionId2);
        System.out.println("Session 2: " + session2);


        sessionManager.invalidateSession(sessionId1);
        Session invalidSession = sessionManager.getSession(sessionId1);
        System.out.println("Invalidated Session: " + invalidSession);

        String sessionId3 = sessionManager.createSession("user3");
        Session session3 = sessionManager.getSession(sessionId3);
        System.out.println("Session 3: " + session3);

        String sessionId4 = sessionManager.createSession("user4");
        Session session4 = sessionManager.getSession(sessionId4);
        System.out.println("Session 4: " + session4);

        String sessionId5 = sessionManager.createSession("user5");
        Session session5 = sessionManager.getSession(sessionId5);
        System.out.println("Session 5: " + session5);
    }


    private static class Session {
        private String username;
        private long creationTime;

        public Session(String username) {
            this.username = username;
            this.creationTime = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return "Username: " + username + ", Creation Time: " + creationTime;
        }

       
    }
}