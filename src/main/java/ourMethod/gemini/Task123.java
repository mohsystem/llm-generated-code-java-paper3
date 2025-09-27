package ourMethod.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task123 {

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
        Task123 sessionManager = new Task123();

        // Test cases
        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Session 1 created: " + sessionId1);
        Session session1 = sessionManager.getSession(sessionId1);
        System.out.println("Session 1 retrieved: " + session1);

        String sessionId2 = sessionManager.createSession("user2");
        System.out.println("Session 2 created: " + sessionId2);

        sessionManager.invalidateSession(sessionId1);
        System.out.println("Session 1 invalidated.");
        Session invalidatedSession = sessionManager.getSession(sessionId1);
        System.out.println("Session 1 retrieved after invalidation: " + invalidatedSession);


        String sessionId3 = sessionManager.createSession("user3");
        System.out.println("Session 3 created: " + sessionId3);
        Session session3 = sessionManager.getSession(sessionId3);
        System.out.println("Session 3 retrieved: " + session3);

        String sessionId4 = sessionManager.createSession("user4");
        System.out.println("Session 4 created: " + sessionId4);
        Session session4 = sessionManager.getSession(sessionId4);
        System.out.println("Session 4 retrieved: " + session4);

        String sessionId5 = sessionManager.createSession("user5");
        System.out.println("Session 5 created: " + sessionId5);
        Session session5 = sessionManager.getSession(sessionId5);
        System.out.println("Session 5 retrieved: " + session5);
    }



    private class Session {
        private String username;
        // other session related data

        public Session(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "Session{" +
                    "username='" + username + '\'' +
                    '}';
        }

    }
}