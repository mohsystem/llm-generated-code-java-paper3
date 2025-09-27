package ZeroShot.claude;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import org.apache.commons.text.StringEscapeUtils;

@WebServlet("/Task38")
public class Task38 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Input Form</title></head><body>");
        out.println("<form method='post' action='Task38'>");
        out.println("Enter text: <input type='text' name='userInput'>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form></body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get and sanitize user input
        String userInput = request.getParameter("userInput");
        if (userInput != null) {
            userInput = StringEscapeUtils.escapeHtml4(userInput);
        } else {
            userInput = "";
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Result</title></head><body>");
        out.println("<h2>You entered: " + userInput + "</h2>");
        out.println("<a href='Task38'>Back to form</a>");
        out.println("</body></html>");
    }
}
