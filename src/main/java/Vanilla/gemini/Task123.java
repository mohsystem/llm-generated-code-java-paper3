package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Task123 {

    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getSessionUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        String sessionId1 = sessionManager.createSession("user1");
        System.out.println("Session created for user1: " + sessionId1);
        System.out.println("User for session " + sessionId1 + ": " + sessionManager.getSessionUser(sessionId1));

        String sessionId2 = sessionManager.createSession("user2");
        System.out.println("Session created for user2: " + sessionId2);
        System.out.println("User for session " + sessionId2 + ": " + sessionManager.getSessionUser(sessionId2));

        sessionManager.deleteSession(sessionId1);
        System.out.println("User for session " + sessionId1 + " after deletion: " + sessionManager.getSessionUser(sessionId1));

        String sessionId3 = sessionManager.createSession("user3");
        System.out.println("Session created for user3: " + sessionId3);
        System.out.println("User for session " + sessionId3 + ": " + sessionManager.getSessionUser(sessionId3));


        String sessionId4 = sessionManager.createSession("user4");
        System.out.println("Session created for user4: " + sessionId4);
        System.out.println("User for session " + sessionId4 + ": " + sessionManager.getSessionUser(sessionId4));

        String sessionId5 = sessionManager.createSession("user5");
        System.out.println("Session created for user5: " + sessionId5);
        System.out.println("User for session " + sessionId5 + ": " + sessionManager.getSessionUser(sessionId5));
    }
}