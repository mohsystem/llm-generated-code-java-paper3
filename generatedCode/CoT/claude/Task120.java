package CoT.claude;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.text.StringEscapeUtils;

@WebServlet("/Task120")
public class Task120 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form method='post'>");
        response.getWriter().println("Enter text: <input type='text' name='userInput'>");
        response.getWriter().println("<input type='submit' value='Submit'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String userInput = request.getParameter("userInput");
        
        // Sanitize input to prevent XSS
        String sanitizedInput = StringEscapeUtils.escapeHtml4(userInput);
        
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Your input:</h2>");
        response.getWriter().println("<p>" + sanitizedInput + "</p>");
        response.getWriter().println("<a href='Task120'>Back</a>");
        response.getWriter().println("</body></html>");
    }
}
