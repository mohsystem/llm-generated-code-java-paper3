package ZeroShot.gemini;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Task38")
public class Task38 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userInput = request.getParameter("userInput");

        out.println("<html>");
        out.println("<head><title>User Input Display</title></head>");
        out.println("<body>");
        if (userInput != null) {
            out.println("<p>You entered: " + escapeHtml(userInput) + "</p>");
        }
        out.println("<form method=\"get\">");
        out.println("<input type=\"text\" name=\"userInput\">");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body></html>");

    }

    private String escapeHtml(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#x27;");
    }


    public static void main(String[] args) throws Exception {
        // Test cases (These would typically be run in a web server environment)
        // You could use a testing framework like JUnit for more robust testing

        // Test 1: No input
        // URL: /Task38
        // Expected output: Form displayed, no user input shown

        // Test 2: Simple text input
        // URL: /Task38?userInput=Hello
        // Expected output: Form displayed, "You entered: Hello" shown

        // Test 3: Input with special characters
        // URL: /Task38?userInput=<script>alert('XSS')</script>
        // Expected output: Form displayed, "You entered: &lt;script&gt;alert('XSS')&lt;/script&gt;" shown (XSS prevented)

        // Test 4: Input with HTML tags
        // URL: /Task38?userInput=<b>bold</b>
        // Expected output: Form displayed, "You entered: &lt;b&gt;bold&lt;/b&gt;" shown (HTML rendered as text)

        // Test 5: Empty input
        // URL: /Task38?userInput=
        // Expected output: Form displayed, "You entered: " shown

    }


}