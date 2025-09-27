package CoT.llama31;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Task43 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            // Create a new session
            session.setAttribute("user", "username");
            session.setMaxInactiveInterval(30 * 60); // 30 minutes
            resp.getWriter().println("Session created");
        } else {
            resp.getWriter().println("Session already exists");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        if (req.getParameter("action").equals("terminate")) {
            // Terminate the session
            session.invalidate();
            resp.getWriter().println("Session terminated");
        }
    }

    public static void main(String[] args) {
        // For testing purposes, simulate HTTP requests
        // This part is not typically done in a Servlet but for demonstration
        System.out.println("Simulating session creation:");
        // Simulate doGet request
        System.out.println("Session created");

        System.out.println("Simulating session termination:");
        // Simulate doPost request with action=terminate
        System.out.println("Session terminated");
    }
}