package Vanilla.gemini;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class Task43 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        if (request.getParameter("newSession") != null) {
            session.invalidate(); // Terminate existing session
            session = request.getSession(true); // Create a new session
            sessionId = session.getId();
        } else if (request.getParameter("terminateSession") != null) {
            session.invalidate();
            sessionId = null;
        }


        response.getWriter().println("<html><body>");
        if (sessionId != null) {
            response.getWriter().println("Session ID: " + sessionId + "<br>");
            response.getWriter().println("<a href=\"?newSession=true\">Start New Session</a><br>");
            response.getWriter().println("<a href=\"?terminateSession=true\">Terminate Session</a><br>");

        } else {
            response.getWriter().println("<a href=\"?newSession=true\">Start New Session</a><br>");

        }
        response.getWriter().println("</body></html>");

    }


    public static void main(String[] args) throws Exception{

        // Test cases (These would typically be run in a web server environment)
        // You would simulate requests to the servlet to test session management

        //Example test (Illustrative - requires a web server setup)
        // 1. Send a request, get a session ID
        // 2. Send another request with the same session ID, verify session continuity.
        // 3. Send a request to terminate the session
        // 4. Send a request, verify a new session is created.
        // 5. Test session expiry (requires setting session timeout)


    }
}