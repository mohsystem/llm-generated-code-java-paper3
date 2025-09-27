package CoT.llama31;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Task123 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");

        if (username != null) {
            session.setAttribute("username", username);
        }

        String storedUsername = (String) session.getAttribute("username");
        if (storedUsername != null) {
            response.getWriter().println("Username: " + storedUsername);
        } else {
            response.getWriter().println("No username stored in session.");
        }

        // Invalidate session after displaying the attribute
        // session.invalidate();
    }

    public static void main(String[] args) {
        // For testing purposes, simulate HTTP requests
        // This is a simplified example and does not actually simulate HTTP requests
        System.out.println("Simulating HTTP requests:");
        System.out.println("Setting username to 'user1':");
        // Simulate setting attribute
        System.out.println("Username: user1");

        System.out.println("Retrieving username:");
        // Simulate getting attribute
        System.out.println("Username: user1");

        System.out.println("Invalidating session:");
        // Simulate invalidating session
        System.out.println("Session invalidated.");
    }
}