package ourMethod.openai;
import java.util.UUID;

public class Task40 {
    public static void main(String[] args) {
        System.out.println(generateCSRFToken());
        System.out.println(validateCSRFToken("12345", "12345"));
        System.out.println(updateUserSettings("username", "email@example.com", "validToken", "validToken"));
        System.out.println(updateUserSettings("username", "email@example.com", "invalidToken", "validToken"));
    }

    public static String generateCSRFToken() {
        return UUID.randomUUID().toString();
    }

    public static boolean validateCSRFToken(String tokenFromRequest, String tokenFromSession) {
        return tokenFromRequest.equals(tokenFromSession);
    }

    public static String updateUserSettings(String username, String email, String csrfToken, String sessionToken) {
        if (validateCSRFToken(csrfToken, sessionToken)) {
            return "Settings updated for user: " + username;
        } else {
            return "CSRF token validation failed.";
        }
    }
}