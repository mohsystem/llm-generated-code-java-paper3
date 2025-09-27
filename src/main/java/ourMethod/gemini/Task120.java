package ourMethod.gemini;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;


public class Task120 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userInput = request.getParameter("userInput");

        if (userInput != null) {
            userInput = StringEscapeUtils.escapeHtml4(userInput);
        } else {
            userInput = ""; //default value if nothing provided
        }
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Input Display</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Input:</h1>");
            out.println("<p>" + userInput + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    public String getServletInfo() {
        return "Displays user input on webpage";
    }

}