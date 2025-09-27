package Vanilla.llama31;
// Task38.java (Servlet)
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Task38 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>Hello, " + userName + "!</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println(
                "<html><body>" +
                "<h1>User Input Display</h1>" +
                "<form method='post'>" +
                "<label for='userName'>Enter your name:</label>" +
                "<input type='text' id='userName' name='userName'><br><br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body></html>");
    }
}