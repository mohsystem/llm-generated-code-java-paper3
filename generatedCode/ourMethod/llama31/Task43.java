package ourMethod.llama31;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.UUID;

public class SessionManager {
    public static void createSession(HttpServletRequest request, HttpServletResponse response) {
        // Generate a unique session ID
        String sessionId = UUID.randomUUID().toString();
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", "someUserId"); // Example attribute

        // Set secure cookie
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setSameSite(Cookie SameSite.Strict);
        response.addCookie(cookie);
    }

    public static void terminateSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}