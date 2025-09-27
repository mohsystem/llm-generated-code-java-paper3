package CoT.llama31;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Task135 extends HttpServlet {

    private static final Map<String, String> csrfTokens = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String csrfToken = generateCsrfToken();
        csrfTokens.put(csrfToken, csrfToken);
        req.setAttribute("csrfToken", csrfToken);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String csrfToken = req.getParameter("csrfToken");
        if (!csrfTokens.containsKey(csrfToken) || !csrfTokens.get(csrfToken).equals(csrfToken)) {
            resp.sendError(403, "Invalid CSRF Token");
            return;
        }
        // Process the request
        resp.getWriter().println("Request processed successfully");
    }

    private static String generateCsrfToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

//    public static void main(String[] args) {
//        // For testing purposes, simulate requests
//        HttpServletRequest request = null; // Mock HttpServletRequest
//        HttpServletResponse response = null; // Mock HttpServletResponse
//
//        // Test case 1: Valid CSRF token
//        String validToken = generateCsrfToken();
//        csrfTokens.put(validToken, validToken);
//        request.setParameter("csrfToken", validToken);
//        doPost(request, response);
//
//        // Test case 2: Invalid CSRF token
//        String invalidToken = "invalid-token";
//        request.setParameter("csrfToken", invalidToken);
//        doPost(request, response);
//
//        // Test case 3: Missing CSRF token
//        request.setParameter("csrfToken", null);
//        doPost(request, response);
//
//        // Test case 4: Valid token but not in session
//        String validButNotInSession = generateCsrfToken();
//        request.setParameter("csrfToken", validButNotInSession);
//        doPost(request, response);
//
//        // Test case 5: Empty token
//        String emptyToken = "";
//        request.setParameter("csrfToken", emptyToken);
//        doPost(request, response);
//    }
}