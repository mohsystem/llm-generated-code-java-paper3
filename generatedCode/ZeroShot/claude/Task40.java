package ZeroShot.claude;

import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Task40 extends HttpServlet {
    private static final Map<String, String> csrfTokens = new HashMap<>();
    private static final SecureRandom random = new SecureRandom();

    private String generateToken() {
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return bytesToHex(bytes);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String sessionId = request.getSession().getId();
            String csrfToken = generateToken();
            csrfTokens.put(sessionId, csrfToken);

            response.setContentType("text/html");
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<form method='POST' action='/updateSettings'>");
            response.getWriter().println("<input type='hidden' name='csrf_token' value='" + csrfToken + "'>");
            response.getWriter().println("Name: <input type='text' name='name'><br>");
            response.getWriter().println("Email: <input type='email' name='email'><br>");
            response.getWriter().println("<input type='submit' value='Update'>");
            response.getWriter().println("</form></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String sessionId = request.getSession().getId();
            String submittedToken = request.getParameter("csrf_token");
            String storedToken = csrfTokens.get(sessionId);

            if (storedToken != null && storedToken.equals(submittedToken)) {
                // Process form submission
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                
                // Update user settings in database
                updateUserSettings(name, email);
                
                response.getWriter().println("Settings updated successfully!");
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().println("Invalid CSRF token!");
            }
            
            // Remove used token
            csrfTokens.remove(sessionId);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUserSettings(String name, String email) {
        // Database update logic here
    }

    // Test cases
    public static void main(String[] args) {
        Task40 task = new Task40();
        
        // Test case 1: Generate and verify valid token
        String token1 = task.generateToken();
        System.out.println("Test 1: Token generated: " + token1);
        
        // Test case 2: Generate multiple tokens - ensure uniqueness
        String token2 = task.generateToken();
        String token3 = task.generateToken();
        System.out.println("Test 2: Tokens are different: " + !token2.equals(token3));
        
        // Test case 3: Token length verification
        System.out.println("Test 3: Token length is 64 chars: " + (token1.length() == 64));
        
        // Test case 4: Token format verification (hex)
        System.out.println("Test 4: Token is hex: " + token1.matches("[0-9a-f]+"));
        
        // Test case 5: Token storage
        String sessionId = "test-session";
        csrfTokens.put(sessionId, token1);
        System.out.println("Test 5: Token stored and retrieved: " + 
            token1.equals(csrfTokens.get(sessionId)));
    }
}
