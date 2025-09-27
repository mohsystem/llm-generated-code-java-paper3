package CoT.llama31;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Task130 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        resp.getWriter().println("Hello, World!");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    }

    public static void main(String[] args) {
        // For testing purposes, you might use an embedded server like Jetty or Tomcat.
        // Here, we just define the servlet.
    }
}