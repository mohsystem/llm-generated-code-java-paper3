package Vanilla.gemini;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/settings")
public class Task40 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate CSRF token
        String csrfToken = generateCSRFToken();
        request.getSession().setAttribute("csrfToken", csrfToken);

        out.println("<html><body>");
        out.println("<form method='post'>");
        out.println("<input type='hidden' name='csrfToken' value='" + csrfToken + "'>");
        out.println("Setting 1: <input type='text' name='setting1'><br>");
        out.println("Setting 2: <input type='text' name='setting2'><br>");
        out.println("<input type='submit' value='Update Settings'>");
        out.println("</form>");
        out.println("</body></html>");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String csrfToken = request.getParameter("csrfToken");
        String expectedToken = (String) request.getSession().getAttribute("csrfToken");

        if (csrfToken != null && csrfToken.equals(expectedToken)) {
            String setting1 = request.getParameter("setting1");
            String setting2 = request.getParameter("setting2");

            // Process settings update
            out.println("<html><body>");
            out.println("Settings updated successfully!<br>");
            out.println("Setting 1: " + setting1 + "<br>");
            out.println("Setting 2: " + setting2 + "<br>");
            out.println("</body></html>");

             request.getSession().removeAttribute("csrfToken"); //Invalidate token after use

        } else {
            out.println("<html><body>");
            out.println("CSRF attack detected!");
            out.println("</body></html>");
        }
    }

    private String generateCSRFToken() {
        return java.util.UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        // Test cases would require a web server environment
        System.out.println("Run this code within a web server (e.g., Tomcat). Test cases require HTTP requests.");


    }
}