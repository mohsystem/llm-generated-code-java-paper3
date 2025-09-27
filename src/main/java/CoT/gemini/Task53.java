package CoT.gemini;
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

        // Test cases
        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Session 1 created: " + sessionId1);
        System.out.println(sessionManager.getSession(sessionId1));

        String sessionId2 = sessionManager.createSession("user2");
        System.out.println("Session 2 created: " + sessionId2);
        System.out.println(sessionManager.getSession(sessionId2));

        sessionManager.invalidateSession(sessionId1);
        System.out.println("Session 1 invalidated: " + sessionManager.getSession(sessionId1));

        String sessionId3 = sessionManager.createSession("user3");
        System.out.println("Session 3 created: " + sessionId3);
        System.out.println(sessionManager.getSession(sessionId3));


        String sessionId4 = sessionManager.createSession("user4");
        System.out.println("Session 4 created: " + sessionId4);
        System.out.println(sessionManager.getSession(sessionId4));

        String sessionId5 = sessionManager.createSession("user5");
        System.out.println("Session 5 created: " + sessionId5);
        System.out.println(sessionManager.getSession(sessionId5));
    }



    private static class UserSession {
        private String username;
         // other session data could be stored here.

        public UserSession(String username) {
            this.username = username;
        }
        @Override
        public String toString(){
            return "Username: " + username;
        }


    }


}