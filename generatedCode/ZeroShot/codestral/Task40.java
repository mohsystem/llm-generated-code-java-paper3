package ZeroShot.codestral;
// Pseudo-code for generating and verifying CSRF tokens
import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.Base64;

public class CsrfProtection {
    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    public static String generateCsrfToken() {
        byte[] randomBytes = new byte[24];
        random.nextBytes(randomBytes);
        return encoder.encodeToString(randomBytes);
    }

    public static boolean isCsrfTokenValid(HttpServletRequest request, HttpSession session) {
        String requestToken = request.getParameter("csrf_token");
        String sessionToken = (String) session.getAttribute("csrf_token");
        return requestToken != null && requestToken.equals(sessionToken);
    }
}