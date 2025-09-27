package CoT.gemini;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task120 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userInput = request.getParameter("userInput");
            if (userInput != null) {
                // Encode user input to prevent XSS
                String encodedUserInput = escapeHtml(userInput);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Input Display</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>You entered: " + encodedUserInput + "</p>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Input Display</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form method=\"post\">");
                out.println("Enter text: <input type=\"text\" name=\"userInput\"><br>");
                out.println("<input type=\"submit\" value=\"Submit\">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

            }
        }
    }


    private String escapeHtml(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#x27;");
                    break;
                case '/':
                    sb.append("&#x2F;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();

    }

}