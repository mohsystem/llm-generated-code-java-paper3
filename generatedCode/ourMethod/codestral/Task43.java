package ourMethod.codestral;
import java.util.UUID;
import javax.servlet.http.*;

public class SessionManager {
    public static String createSession(HttpSession session) {
        String sessionId = UUID.randomUUID().toString();
        session.setAttribute("sessionId", sessionId);
        return sessionId;
    }

    public static void terminateSession(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }
}