package ZeroShot.gemini;
import javax.servlet.http.*;
import java.util.UUID;

public class Task135 {

    public static String generateCSRFToken() {
        return UUID.randomUUID().toString();
    }

    public static void storeCSRFToken(HttpServletRequest request, HttpServletResponse response, String token) {
        HttpSession session = request.getSession();
        session.setAttribute("csrfToken", token);
        response.setHeader("CSRF-Token", token); // Optional: For APIs
    }
    
    public static boolean verifyCSRFToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        String storedToken = (String) session.getAttribute("csrfToken");
        String requestToken = request.getHeader("CSRF-Token"); // For APIs
        if (requestToken == null) {
            requestToken = request.getParameter("csrfToken"); // For forms
        }

        if (storedToken != null && requestToken != null && storedToken.equals(requestToken)) {
             session.removeAttribute("csrfToken"); //Important: prevent reuse!
             return true;
        }
        return false;
    }

    public static void main(String[] args) {
         // Test cases (Illustrative - requires a web server context to run properly)
        HttpServletRequest mockRequest = null; // Replace with a mock request object
        HttpServletResponse mockResponse = null; // Replace with a mock response object

        // Test 1: Generate and store token
        String token1 = generateCSRFToken();
        storeCSRFToken(mockRequest, mockResponse, token1);

        // Test 2: Verify valid token
        // ... (Set up mockRequest with the token1)
        // boolean valid1 = verifyCSRFToken(mockRequest);

        // Test 3: Verify invalid token
        // ... (Set up mockRequest with an incorrect token)
        // boolean valid2 = verifyCSRFToken(mockRequest);

        // Test 4: Verify token after verification (should be invalid)
        // boolean valid3 = verifyCSRFToken(mockRequest); 

        // Test 5: Verify with no session
        // ... (Set up mockRequest without a session)
        // boolean valid4 = verifyCSRFToken(mockRequest);

        System.out.println("Test cases completed.  These require a web server context to fully execute.");
    }
}