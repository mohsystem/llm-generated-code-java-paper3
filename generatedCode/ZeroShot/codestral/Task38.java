package ZeroShot.codestral;
// Java Servlet code
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Task38 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("user");
        out.println("<html><body>");
        out.println("<h1>Welcome, " + name + "</h1>");
        out.println("</body></html>");
    }

    public static void main(String[] args) {
        // This is just for testing the functionality.
        // Normally, this code would be run on a server, and the main method would not be necessary.
        Task38 task = new Task38();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("user")).thenReturn("TestUser");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        try {
            task.doPost(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringWriter.toString());
    }
}