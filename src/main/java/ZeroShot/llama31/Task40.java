package ZeroShot.llama31;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task40 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String csrfToken = generateCSRFToken();
        req.getSession().setAttribute("csrfToken", csrfToken);
        req.setAttribute("csrfToken", csrfToken);
        req.getRequestDispatcher("updateSettings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String csrfTokenFromSession = (String) req.getSession().getAttribute("csrfToken");
        String csrfTokenFromRequest = req.getParameter("csrfToken");
        if (csrfTokenFromSession.equals(csrfTokenFromRequest)) {
            // Process the form data
            System.out.println("Form data processed successfully");
        } else {
            System.out.println("CSRF attack detected");
        }
    }

    private String generateCSRFToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

//    public static void main(String[] args) {
//        // For testing purposes, you can simulate the request and response
//        // This is a very simplified example and should not be used in production
//        HttpServletRequest request = null; // Mock HttpServletRequest
//        HttpServletResponse response = null; // Mock HttpServletResponse
//        Task40 task40 = new Task40();
//        task40.doGet(request, response);
//        task40.doPost(request, response);
//    }
}