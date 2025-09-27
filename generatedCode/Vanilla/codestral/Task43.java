package Vanilla.codestral;
import javax.servlet.http.*;

public class SessionManager {
    public HttpSession createSession(HttpServletRequest request) {
        return request.getSession(true);
    }

    public void storeDataInSession(HttpSession session, String key, String value) {
        session.setAttribute(key, value);
    }

    public void terminateSession(HttpSession session) {
        session.invalidate();
    }
}