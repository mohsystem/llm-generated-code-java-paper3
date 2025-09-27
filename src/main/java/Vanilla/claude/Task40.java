package Vanilla.claude;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

@WebServlet("/Task40")
public class Task40 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Generate CSRF token
        HttpSession session = request.getSession();
        String csrfToken = generateCSRFToken();
        session.setAttribute("csrf_token", csrfToken);
        
        // Output form with CSRF token
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form method='post' action='Task40'>");
        response.getWriter().println("<input type='hidden' name='csrf_token' value='" + csrfToken + "'>");
        response.getWriter().println("Name: <input type='text' name='name'><br>");
        response.getWriter().println("Email: <input type='email' name='email'><br>");
        response.getWriter().println("<input type='submit' value='Update Settings'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("csrf_token");
        String requestToken = request.getParameter("csrf_token");
        
        if (sessionToken != null && sessionToken.equals(requestToken)) {
            // Process form submission
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            response.getWriter().println("Settings updated successfully!");
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF Token");
        }
    }
    
    private String generateCSRFToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) {
        // Note: This is just to show test cases. In reality, this would be tested with a web server
        Task40 servlet = new Task40();
        
        // Test Case 1: Generate new CSRF token
        String token1 = servlet.generateCSRFToken();
        System.out.println("Test 1 - Token generated: " + (token1 != null && token1.length() > 0));
        
        // Test Case 2: Generate different tokens
        String token2 = servlet.generateCSRFToken();
        System.out.println("Test 2 - Tokens are different: " + !token1.equals(token2));
        
        // Test Case 3: Token length check
        System.out.println("Test 3 - Token length valid: " + (token1.length() >= 32));
        
        // Test Case 4: Token format check (Base64)
        System.out.println("Test 4 - Token is Base64: " + token1.matches("^[A-Za-z0-9+/=]+$"));
        
        // Test Case 5: Generate multiple tokens rapidly
        boolean allDifferent = true;
        String[] tokens = new String[10];
        for(int i = 0; i < 10; i++) {
            tokens[i] = servlet.generateCSRFToken();
            for(int j = 0; j < i; j++) {
                if(tokens[i].equals(tokens[j])) {
                    allDifferent = false;
                    break;
                }
            }
        }
        System.out.println("Test 5 - Multiple tokens unique: " + allDifferent);
    }
}
