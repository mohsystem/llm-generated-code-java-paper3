package ourMethod.claude;

// Task40.java
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Task40")
public class Task40 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final SecureRandom secureRandom = new SecureRandom();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Generate CSRF token
        HttpSession session = request.getSession();
        String csrfToken = generateCSRFToken();
        session.setAttribute("csrfToken", csrfToken);
        
        // Output form with CSRF token
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form method='post' action='Task40'>");
        response.getWriter().println("<input type='hidden' name='csrf_token' value='" + csrfToken + "'/>");
        response.getWriter().println("Name: <input type='text' name='name'/><br/>");
        response.getWriter().println("Email: <input type='email' name='email'/><br/>");
        response.getWriter().println("<input type='submit' value='Update'/>");
        response.getWriter().println("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // Validate CSRF token
            HttpSession session = request.getSession(false);
            if (session == null) {
                throw new SecurityException("Invalid session");
            }
            
            String sessionToken = (String) session.getAttribute("csrfToken");
            String requestToken = request.getParameter("csrf_token");
            
            if (sessionToken == null || requestToken == null || !sessionToken.equals(requestToken)) {
                throw new SecurityException("Invalid CSRF token"); 
            }
            
            // Process form submission securely
            String name = sanitizeInput(request.getParameter("name"));
            String email = sanitizeInput(request.getParameter("email"));
            
            // Update user settings in database here
            // Use prepared statements to prevent SQL injection
            
            response.getWriter().println("Settings updated successfully!");
            
        } catch (SecurityException e) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }
    
    private String generateCSRFToken() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }
    
    private String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        // Basic XSS prevention
        return input.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    // Test cases
    public static void main(String[] args) {
        Task40 task = new Task40();
        
        // Test 1: Generate CSRF token
        String token = task.generateCSRFToken();
        System.out.println("Test 1 - Token generated: " + (token != null && token.length() > 0));
        
        // Test 2: Generate unique tokens
        String token1 = task.generateCSRFToken();
        String token2 = task.generateCSRFToken(); 
        System.out.println("Test 2 - Unique tokens: " + !token1.equals(token2));
        
        // Test 3: Input sanitization - null input
        String sanitized = task.sanitizeInput(null);
        System.out.println("Test 3 - Null input handled: " + sanitized.equals(""));
        
        // Test 4: Input sanitization - XSS attempt
        String xssInput = "<script>alert('xss')</script>";
        sanitized = task.sanitizeInput(xssInput);
        System.out.println("Test 4 - XSS prevented: " + !sanitized.contains("<script>"));
        
        // Test 5: Input sanitization - normal input
        String normalInput = "John Doe";
        sanitized = task.sanitizeInput(normalInput);
        System.out.println("Test 5 - Normal input preserved: " + sanitized.equals(normalInput));
    }
}
