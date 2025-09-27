package CoT.gemini;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/updateSettings")
public class Task40 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Generate CSRF token
        String csrfToken = UUID.randomUUID().toString();
        request.getSession().setAttribute("csrfToken", csrfToken);

        // Display form with hidden CSRF token field
        response.setContentType("text/html");
        response.getWriter().println("<form action=\"updateSettings\" method=\"post\">");
        response.getWriter().println("<input type=\"hidden\" name=\"csrfToken\" value=\"" + csrfToken + "\">");
        // Other form fields for user settings
        response.getWriter().println("<input type=\"text\" name=\"setting1\" value=\"\">");
        response.getWriter().println("<input type=\"submit\" value=\"Update\">");
        response.getWriter().println("</form>");


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Verify CSRF token
        String requestToken = request.getParameter("csrfToken");
        String sessionToken = (String) request.getSession().getAttribute("csrfToken");


        if (requestToken != null && sessionToken != null && requestToken.equals(sessionToken)) {

            // Process form data and update user settings
            String setting1 = request.getParameter("setting1");
            // Update user settings in database or other storage

            response.getWriter().println("Settings updated successfully.");
            // Invalidate the token after it has been used
             request.getSession().removeAttribute("csrfToken");

        } else {
            // CSRF attack detected
            response.getWriter().println("CSRF attack detected!");
        }
    }



    public static void main(String[] args) {
         // Test cases (These would typically be handled by a testing framework)
         // Since this is a web application, these tests are illustrative and would require
         // setting up a testing environment with mock requests and responses.
    }
}