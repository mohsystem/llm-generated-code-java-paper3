package Vanilla.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task53 {
    public static class SessionManager {
        private Map<Integer, Boolean> sessions;

        public SessionManager() {
            this.sessions = new HashMap<>();
        }

        public void startSession(int userId) {
            this.sessions.put(userId, true);
        }

        public void endSession(int userId) {
            this.sessions.remove(userId);
        }

        public boolean isSessionActive(int userId) {
            return this.sessions.containsKey(userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession(1);
        sessionManager.startSession(2);
        System.out.println(sessionManager.isSessionActive(1)); // true
        sessionManager.endSession(1);
        System.out.println(sessionManager.isSessionActive(1)); // false
    }
}