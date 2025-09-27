package Vanilla.llama31;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task135 {
    public static void main(String[] args) {
        // Test cases
        System.out.println("Java CSRF Protection");
        String token = generateCsrfToken();
        System.out.println("Generated Token: " + token);
        boolean isValid = validateCsrfToken(token, token);
        System.out.println("Is Token Valid? " + isValid);
    }

    public static String generateCsrfToken() {
        return UUID.randomUUID().toString();
    }

    public static boolean validateCsrfToken(String expectedToken, String actualToken) {
        return expectedToken.equals(actualToken);
    }

    public static void setCsrfToken(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("CSRF-Token", token);
        response.addCookie(cookie);
    }

    public static String getCsrfToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("CSRF-Token")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}