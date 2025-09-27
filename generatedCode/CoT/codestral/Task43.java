package CoT.codestral;
import javax.servlet.http.*;

public class SessionManager extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", "username");
        // Perform other operations
        session.invalidate(); // To terminate the session
    }
}