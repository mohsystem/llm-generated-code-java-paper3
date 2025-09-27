package ourMethod.gemini;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task43 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.getWriter().println("No action specified.");
            return;
        }

        HttpSession session = request.getSession();

        switch (action) {
            case "create":
                createSession(session, response);
                break;
            case "get":
                getSessionInfo(session, response);
                break;
            case "terminate":
                terminateSession(session, response);
                break;
            default:
                response.getWriter().println("Invalid action specified.");
        }
    }

    private void createSession(HttpSession session, HttpServletResponse response) throws IOException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] sessionIdBytes = new byte[32]; // Use a sufficiently long session ID
        secureRandom.nextBytes(sessionIdBytes);
        String sessionId = Base64.getUrlEncoder().withoutPadding().encodeToString(sessionIdBytes);
        session.setAttribute("sessionId", sessionId);

        session.setMaxInactiveInterval(15 * 60); // Set session timeout (e.g., 15 minutes)
        response.getWriter().println("Session created with ID: " + sessionId);

    }

    private void getSessionInfo(HttpSession session, HttpServletResponse response) throws IOException {
        String sessionId = (String) session.getAttribute("sessionId");
        if (sessionId != null) {
            response.getWriter().println("Session ID: " + sessionId);
        } else {
            response.getWriter().println("No active session.");
        }
    }

    private void terminateSession(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.getWriter().println("Session terminated.");
    }

    public static void main(String[] args) throws ServletException, IOException{
    // Test cases
        HttpServletRequest request1 = new MockHttpServletRequest("create");
        HttpServletResponse response1 = new MockHttpServletResponse();
        new Task43().doGet(request1,response1);
        System.out.println(response1.getOutput());


        HttpSession session = request1.getSession();

        HttpServletRequest request2 = new MockHttpServletRequest("get");
        request2.setSession(session);
        HttpServletResponse response2 = new MockHttpServletResponse();
        new Task43().doGet(request2,response2);
        System.out.println(response2.getOutput());


        HttpServletRequest request3 = new MockHttpServletRequest("terminate");
        request3.setSession(session);
        HttpServletResponse response3 = new MockHttpServletResponse();
        new Task43().doGet(request3,response3);
        System.out.println(response3.getOutput());


        HttpServletRequest request4 = new MockHttpServletRequest("get");
        request4.setSession(session);
        HttpServletResponse response4 = new MockHttpServletResponse();
        new Task43().doGet(request4,response4);
        System.out.println(response4.getOutput());



        HttpServletRequest request5 = new MockHttpServletRequest("create");
        HttpServletResponse response5 = new MockHttpServletResponse();
        new Task43().doGet(request5,response5);
        System.out.println(response5.getOutput());

    }
}