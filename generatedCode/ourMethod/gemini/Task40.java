package ourMethod.gemini;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class Task40 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String csrfToken = (String) session.getAttribute("csrfToken");
        if (csrfToken == null) {
            csrfToken = UUID.randomUUID().toString();
            session.setAttribute("csrfToken", csrfToken);
        }

        out.println("<html><head><title>User Settings</title></head><body>");
        out.println("<h1>Update User Settings</h1>");
        out.println("<form method=\"post\">");
        out.println("<input type=\"hidden\" name=\"csrfToken\" value=\"" + csrfToken + "\">");
        out.println("Setting 1: <input type=\"text\" name=\"setting1\"><br>");
        out.println("Setting 2: <input type=\"text\" name=\"setting2\"><br>");
        out.println("<input type=\"submit\" value=\"Update\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String csrfToken = (String) session.getAttribute("csrfToken");
        String requestToken = request.getParameter("csrfToken");

        if (csrfToken != null && csrfToken.equals(requestToken)) {
            String setting1 = request.getParameter("setting1");
            String setting2 = request.getParameter("setting2");

            // Process user settings updates
            out.println("<html><body>");
            out.println("Settings updated successfully!<br>");
            out.println("Setting 1: " + setting1 + "<br>");
            out.println("Setting 2: " + setting2 + "<br>");
            out.println("</body></html>");

             // Invalidate the token after successful processing to prevent replay attacks.
            session.removeAttribute("csrfToken");

        } else {
            out.println("<html><body>");
            out.println("CSRF attack detected!");
            out.println("</body></html>");
        }
    }

    public static void main(String[] args) throws IOException{
    // Test cases would involve simulating HTTP requests and responses, which is not easily done within a single Java file.
    // For testing, you would typically deploy this servlet to a web server and use a tool like curl or a web browser to send requests.

    // Example test case using curl:
        // curl -X GET http://localhost:8080/your-app/Task40
        // curl -X POST http://localhost:8080/your-app/Task40 -d "csrfToken=<token_value>&setting1=value1&setting2=value2"
    }
}