package CoT.claude;

import java.security.SecureRandom;
import javax.servlet.http.*;
import java.io.*;

public class Task40 extends HttpServlet {
    private static final SecureRandom secureRandom = new SecureRandom();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Generate CSRF token
        String csrfToken = generateCSRFToken();
        
        // Store token in session
        HttpSession session = request.getSession();
        session.setAttribute("csrf_token", csrfToken);
        
        // Generate form with CSRF token
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form method='post' action='update'>");
        out.println("<input type='hidden' name='csrf_token' value='" + csrfToken + "'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Email: <input type='email' name='email'><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");
        out.println("</body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Validate CSRF token
        String formToken = request.getParameter("csrf_token");
        String sessionToken = (String) request.getSession().getAttribute("csrf_token");
        
        if (formToken == null || !formToken.equals(sessionToken)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF Token");
            return;
        }
        
        // Process form data securely
        String name = sanitizeInput(request.getParameter("name"));
        String email = sanitizeInput(request.getParameter("email"));
        
        // Update user settings in database (implementation omitted)
        
        response.getWriter().println("Settings updated successfully");
    }
    
    private String generateCSRFToken() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        return bytesToHex(randomBytes);
    }
    
    private String sanitizeInput(String input) {
        if (input == null) return "";
        return input.replaceAll("[<>\\"'&]", "");
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
