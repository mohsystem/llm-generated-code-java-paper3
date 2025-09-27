package ourMethod.codestral;
import java.util.*;

public class Task123 {
    private Map<String, Object> sessions = new HashMap<>();

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Object());
        return sessionId;
    }

    public Object getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task123 manager = new Task123();
        String sessionId = manager.createSession();
        System.out.println("Session created: " + sessionId);
        System.out.println("Session data: " + manager.getSession(sessionId));
        manager.endSession(sessionId);
        System.out.println("Session ended: " + sessionId);
    }
}