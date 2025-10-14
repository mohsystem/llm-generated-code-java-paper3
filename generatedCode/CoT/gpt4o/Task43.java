package CoT.openai;
// Java code for managing user sessions securely
import java.util.HashMap;
import java.util.UUID;

public class Task43 {

    private HashMap<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void terminateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task43 app = new Task43();
        
        String session1 = app.createSession("user1");
        String session2 = app.createSession("user2");
        
        System.out.println("Session1 valid: " + app.isValidSession(session1));
        System.out.println("Session2 valid: " + app.isValidSession(session2));
        
        app.terminateSession(session1);
        
        System.out.println("Session1 valid after termination: " + app.isValidSession(session1));
        System.out.println("Session2 valid after termination: " + app.isValidSession(session2));
        
        String session3 = app.createSession("user3");
        
        System.out.println("Session3 valid: " + app.isValidSession(session3));
    }
}