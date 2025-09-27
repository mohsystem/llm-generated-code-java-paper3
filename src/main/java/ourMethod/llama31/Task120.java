package ourMethod.llama31;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Task120")
public class Task120 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userInput = request.getParameter("input");
        if (userInput != null) {
            // Escape user input to prevent XSS
            userInput = java.net.URLEncoder.encode(userInput, "UTF-8");
        } else {
            userInput = "";
        }
        response.setContentType("text/html");
        response.getWriter().println("<html><body>User Input: " + userInput + "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public static void main(String[] args) {
        // For testing purposes
        System.out.println("Servlet initialized");
    }
}