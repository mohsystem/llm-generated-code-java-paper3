package ZeroShot.gemini;
import java.util.HashMap;
import java.util.UUID;

class Task123 {

    private HashMap<String, UserSession> sessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new UserSession(username));
        return sessionId;
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public String getUsername(String sessionId) {
        if (isValidSession(sessionId)) {
            return sessions.get(sessionId).getUsername();
        }
        return null;
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }


    private class UserSession {
        private String username;


        public UserSession(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        String session1 = sessionManager.createSession("user1");
        String session2 = sessionManager.createSession("user2");

        System.out.println("Session 1 valid: " + sessionManager.isValidSession(session1)); // True
        System.out.println("Session 2 valid: " + sessionManager.isValidSession(session2)); // True
        System.out.println("Session 1 username: " + sessionManager.getUsername(session1)); // user1

        sessionManager.invalidateSession(session1);

        System.out.println("Session 1 valid after invalidation: " + sessionManager.isValidSession(session1)); // False
        System.out.println("Session 2 username: " + sessionManager.getUsername(session2)); // user2


    }
}