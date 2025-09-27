package ZeroShot.gpt4o;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Task38")
public class Task38 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("userInput");
        if(userInput != null) {
            userInput = userInput.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>User Input:</h1>");
        response.getWriter().println("<p>" + userInput + "</p>");
        response.getWriter().println("</body></html>");
    }
}