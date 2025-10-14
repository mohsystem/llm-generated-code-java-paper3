package CoT.openai;
import java.util.HashMap;
import java.util.UUID;

public class Task123 {

    static class SessionManager {
        private HashMap<String, String> sessions = new HashMap<>();

        public String createSession(String userId) {
            String sessionId = UUID.randomUUID().toString();
            sessions.put(sessionId, userId);
            return sessionId;
        }

        public String getUserId(String sessionId) {
            return sessions.get(sessionId);
        }

        public boolean removeSession(String sessionId) {
            return sessions.remove(sessionId) != null;
        }

        public boolean isValidSession(String sessionId) {
            return sessions.containsKey(sessionId);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        
        // Test cases
        String session1 = manager.createSession("user1");
        String session2 = manager.createSession("user2");
        String session3 = manager.createSession("user3");
        String session4 = manager.createSession("user4");
        String session5 = manager.createSession("user5");

        System.out.println(manager.getUserId(session1)); // Should print "user1"
        System.out.println(manager.isValidSession(session2)); // Should print "true"
        System.out.println(manager.removeSession(session3)); // Should print "true"
        System.out.println(manager.isValidSession(session3)); // Should print "false"
        System.out.println(manager.getUserId(session5)); // Should print "user5"
    }
}