package ZeroShot.codestral;
import java.util.HashSet;
import java.util.UUID;

public class Task123 {
    private HashSet<String> sessions = new HashSet<>();

    public String login() {
        String sessionId = UUID.randomUUID().toString();
        sessions.add(sessionId);
        return sessionId;
    }

    public void logout(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task123 sessionManager = new Task123();

        String sessionId1 = sessionManager.login();
        String sessionId2 = sessionManager.login();

        System.out.println("Logged in sessions: " + sessionManager.sessions.size());

        sessionManager.logout(sessionId1);

        System.out.println("Logged in sessions: " + sessionManager.sessions.size());
    }
}