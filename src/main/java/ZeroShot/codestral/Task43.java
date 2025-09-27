package ZeroShot.codestral;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if (action != null && action.equals("logout")) {
            session.invalidate();
            response.getWriter().write("Logged out");
        } else {
            session.setAttribute("username", "user");
            response.getWriter().write("Logged in");
        }
    }
}