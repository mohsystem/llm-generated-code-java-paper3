package CoT.codestral;
// Problem understanding: The program should manage user sessions for a web application, which might include generating session IDs, storing session data, and invalidating sessions when needed.
// Security requirements: The program should prevent session fixation attacks by generating a new session ID when a user logs in and invalidating the old session. It should also prevent session hijacking by checking the user's IP address and user agent string.

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task53 {
    private Map<String, Session> sessions = new HashMap<>();

    public String login(String ip, String userAgent) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(ip, userAgent);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public boolean validate(String sessionId, String ip, String userAgent) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            return false;
        }
        return session.getIp().equals(ip) && session.getUserAgent().equals(userAgent);
    }

    public void logout(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        Task53 sessionManager = new Task53();
        String sessionId = sessionManager.login("127.0.0.1", "Mozilla/5.0");
        System.out.println("Login successful. Session ID: " + sessionId);
        System.out.println("Validate session: " + sessionManager.validate(sessionId, "127.0.0.1", "Mozilla/5.0"));
        sessionManager.logout(sessionId);
        System.out.println("Validate session after logout: " + sessionManager.validate(sessionId, "127.0.0.1", "Mozilla/5.0"));
    }
}

class Session {
    private String ip;
    private String userAgent;

    public Session(String ip, String userAgent) {
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }
}