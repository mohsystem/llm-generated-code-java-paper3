package ZeroShot.gemini;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task43 extends HttpServlet {

    private static final SecureRandom secureRandom = new SecureRandom();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            invalidateSession(session, response);
            return;
        }

        if (session.isNew()) {
            String sessionId = generateSessionId();
            session.setAttribute("sessionId", sessionId);
            response.getWriter().println("New session created with ID: " + sessionId);

        } else {
            String sessionId = (String) session.getAttribute("sessionId");
            response.getWriter().println("Existing session with ID: " + sessionId);
        }


    }

    private void invalidateSession(HttpSession session, HttpServletResponse response) throws IOException {
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()); // Redirect after logout
    }


    private String generateSessionId() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static void main(String[] args) throws IOException {
        // Test cases would involve simulating HTTP requests and responses, which is beyond the scope of a simple main method.
        //  Testing would typically be done using a web server and testing frameworks.
        System.out.println("This servlet needs to be deployed in a web server to test.  This main method is a placeholder.");

        // Example usage (not executable here):
        //  HttpServletRequest request = ...; // Mock request
        //  HttpServletResponse response = ...; // Mock response
        //  Task43 servlet = new Task43();
        //  servlet.doGet(request, response);
    }
}