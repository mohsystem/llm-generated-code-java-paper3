package ZeroShot.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Task53 {

    private Map<String, UserSession> sessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        UserSession session = new UserSession(username);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");

        System.out.println(sessionManager.getSession(session1));
        System.out.println(sessionManager.getSession(session2));

        sessionManager.invalidateSession(session1);

        System.out.println(sessionManager.getSession(session1)); // Should be null
        System.out.println(sessionManager.getSession(session2));

                String session3 = sessionManager.createSession("user3");
        String session4 = sessionManager.createSession("user4");
        String session5 = sessionManager.createSession("user5");

        System.out.println(sessionManager.getSession(session3));
        System.out.println(sessionManager.getSession(session4));
        System.out.println(sessionManager.getSession(session5));
    }


    private static class UserSession {
        private String username;



        public UserSession(String username) {
            this.username = username;

        }



        @Override
        public String toString() {
            return "UserSession{" +
                    "username='" + username + '\'' +
                    '}';
        }
    }
}