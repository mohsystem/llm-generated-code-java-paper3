package ourMethod.claude;

// Task38.java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringEscapeUtils;

@WebServlet("/form")
public class Task38 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Input Form</title></head>");
        out.println("<body>");
        out.println("<form method='post' action='form'>");
        out.println("Enter text: <input type='text' name='userInput' maxlength='100' required>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        // Get input and validate
        String userInput = request.getParameter("userInput");
        if (userInput == null || userInput.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Sanitize input
        userInput = StringEscapeUtils.escapeHtml4(userInput.trim());
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Input Result</title></head>");
        out.println("<body>");
        out.println("<h2>You entered:</h2>");
        out.println("<p>" + userInput + "</p>");
        out.println("<a href='form'>Back to form</a>");
        out.println("</body></html>");
    }
}
