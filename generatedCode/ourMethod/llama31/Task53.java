package ourMethod.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task53 {
    private static Map<String, Session> sessions = new HashMap<>();

    public static void createSession(HttpServletRequest request, HttpServletResponse response, String username) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(username, sessionId, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30));
        sessions.put(sessionId, session);

        Cookie sessionCookie = new Cookie("sessionId", sessionId);
        sessionCookie.setSecure(true); // For HTTPS
        sessionCookie.setHttpOnly(true); // Prevents JavaScript access
        response.addCookie(sessionCookie);
    }

    public static void validateSession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String sessionId = cookie.getValue();
                    Session session = sessions.get(sessionId);
                    if (session != null && session.isValid()) {
                        // Session is valid, proceed with request
                        System.out.println("Session is valid for user: " + session.getUsername());
                        return;
                    }
                }
            }
        }
        // Session is invalid or does not exist
        System.out.println("Invalid or expired session");
    }

    public static void terminateSession(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String sessionId = cookie.getValue();
                    sessions.remove(sessionId);
                    cookie.setMaxAge(0); // Invalidate the cookie
                    response.addCookie(cookie);
                    return;
                }
            }
        }
    }

    private static class Session {
        private String username;
        private String sessionId;
        private long expirationTime;

        public Session(String username, String sessionId, long expirationTime) {
            this.username = username;
            this.sessionId = sessionId;
            this.expirationTime = expirationTime;
        }

        public boolean isValid() {
            return System.currentTimeMillis() < expirationTime;
        }

        public String getUsername() {
            return username;
        }
    }

    public static void main(String[] args) {
        // Example usage
        HttpServletRequest request = null; // Mock request
        HttpServletResponse response = null; // Mock response

        createSession(request, response, "user123");
        validateSession(request);
        terminateSession(request, response);
    }
}