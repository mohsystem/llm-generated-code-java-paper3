package CoT.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
public class Task135 {

    public static String generateCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("csrfToken");
        if (token == null) {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bytes = new byte[32];
            secureRandom.nextBytes(bytes);
            token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
            session.setAttribute("csrfToken", token);
        }
        return token;
    }

    public static boolean verifyCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String expectedToken = (String) session.getAttribute("csrfToken");
        String actualToken = request.getParameter("csrfToken");

        if (expectedToken != null && actualToken != null && expectedToken.equals(actualToken)) {
            // Token validated, remove it to prevent double-spending
            session.removeAttribute("csrfToken"); 
            return true;
        }
        return false;
    }
}