package CoT.gpt4o;
// Java code block
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task38 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userInput = request.getParameter("userInput");
        out.println("<html><body>");
        out.println("<h2>User Input:</h2>");
        out.println("<p>" + userInput + "</p>");
        out.println("</body></html>");
    }
    
    public static void main(String[] args) {
        // Main method for testing the servlet in a non-web environment would not apply.
    }
}