package ZeroShot.llama31;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task135 {
    public static void main(String[] args) {
        // Test cases
        testCSRFProtection();
    }

    public static void testCSRFProtection() {
        // Simulate HTTP request and response
        HttpServletRequest request = null; // Replace with actual request
        HttpServletResponse response = null; // Replace with actual response

        // Generate CSRF token
        String csrfToken = generateCSRFToken();
        setCSRFTokenInCookie(response, csrfToken);

        // Validate CSRF token
        boolean isValid = validateCSRFToken(request, csrfToken);
        System.out.println("Is CSRF token valid? " + isValid);
    }

    public static String generateCSRFToken() {
        return UUID.randomUUID().toString();
    }

    public static void setCSRFTokenInCookie(HttpServletResponse response, String csrfToken) {
        Cookie cookie = new Cookie("CSRF-Token", csrfToken);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static boolean validateCSRFToken(HttpServletRequest request, String expectedToken) {
        Cookie[] cookies = request.getCookies();
        String actualToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("CSRF-Token")) {
                    actualToken = cookie.getValue();
                    break;
                }
            }
        }
        return actualToken != null && actualToken.equals(expectedToken);
    }
}