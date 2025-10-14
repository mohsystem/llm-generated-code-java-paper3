package ZeroShot.openai;
public class Task123 {
    private static class SessionManager {
        private HashMap<String, Long> sessions = new HashMap<>();
        private final long sessionTimeout = 300000; // 5 minutes in milliseconds

        public synchronized void createSession(String userId) {
            sessions.put(userId, System.currentTimeMillis());
        }

        public synchronized boolean isSessionActive(String userId) {
            Long lastActive = sessions.get(userId);
            return lastActive != null && (System.currentTimeMillis() - lastActive < sessionTimeout);
        }

        public synchronized void refreshSession(String userId) {
            if (sessions.containsKey(userId)) {
                sessions.put(userId, System.currentTimeMillis());
            }
        }

        public synchronized void endSession(String userId) {
            sessions.remove(userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Test cases
        sm.createSession("user1");
        System.out.println(sm.isSessionActive("user1")); // true
        sm.endSession("user1");
        System.out.println(sm.isSessionActive("user1")); // false

        sm.createSession("user2");
        System.out.println(sm.isSessionActive("user2")); // true
        try { Thread.sleep(310000); } catch (InterruptedException e) {}
        System.out.println(sm.isSessionActive("user2")); // false

        sm.createSession("user3");
        sm.refreshSession("user3");
        System.out.println(sm.isSessionActive("user3")); // true
    }
}