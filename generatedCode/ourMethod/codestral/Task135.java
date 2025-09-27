package ourMethod.codestral;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Task135 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static String generateCsrfToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static boolean isCsrfTokenValid(HttpServletRequest request, HttpServletResponse response) {
        String requestToken = request.getParameter("csrf_token");
        HttpSession session = request.getSession(false);
        if (session != null) {
            String sessionToken = (String) session.getAttribute("csrf_token");
            if (sessionToken != null && sessionToken.equals(requestToken)) {
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return false;
    }

    // Example usage
    public static void main(String[] args) {
        // In a real-world application, this would be part of a servlet or filter
        HttpServletRequest request = null; // Assume request is available
        HttpServletResponse response = null; // Assume response is available

        // When a user session is created, generate a CSRF token and store it in the session
        String csrfToken = generateCsrfToken();
        HttpSession session = request.getSession(true);
        session.setAttribute("csrf_token", csrfToken);

        // When a form is submitted, verify the CSRF token
        if (isCsrfTokenValid(request, response)) {
            // Process the form submission
        } else {
            // Reject the form submission
        }
    }
}