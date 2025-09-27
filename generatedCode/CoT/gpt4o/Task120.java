package CoT.gpt4o;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task120 extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String userInput = request.getParameter("userInput");
            if (userInput != null) {
                // Escaping HTML to prevent XSS
                String escapedInput = escapeHtml(userInput);
                out.println("<html><body>");
                out.println("<h2>User Input:</h2>");
                out.println("<p>" + escapedInput + "</p>");
                out.println("</body></html>");
            } else {
                out.println("<html><body><h2>No input provided</h2></body></html>");
            }
        } finally {
            out.close();
        }
    }

    private String escapeHtml(String input) {
        if (input == null) return null;
        return input.replaceAll("&", "&amp;")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;")
                    .replaceAll("'", "&#x27;");
    }
}