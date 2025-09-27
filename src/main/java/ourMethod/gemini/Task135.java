package ourMethod.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Task135 {

    public static String generateCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[32];
        secureRandom.nextBytes(tokenBytes);
        String csrfToken = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
        session.setAttribute("csrfToken", csrfToken);
        return csrfToken;
    }

    public static boolean validateCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        String storedToken = (String) session.getAttribute("csrfToken");
        String requestToken = request.getParameter("csrfToken");
        if (storedToken == null || requestToken == null) {
            return false;
        }

        return storedToken.equals(requestToken);
    }


//    public static void main(String[] args) {
//        // Test cases (using mock HttpServletRequest and HttpSession)
//        MockHttpServletRequest request1 = new MockHttpServletRequest();
//        String token1 = generateCsrfToken(request1);
//        request1.addParameter("csrfToken", token1);
//        System.out.println("Test 1: " + validateCsrfToken(request1)); // Expected: true
//
//        MockHttpServletRequest request2 = new MockHttpServletRequest();
//        generateCsrfToken(request2);
//        request2.addParameter("csrfToken", "invalid_token");
//        System.out.println("Test 2: " + validateCsrfToken(request2)); // Expected: false
//
//        MockHttpServletRequest request3 = new MockHttpServletRequest();
//        System.out.println("Test 3: " + validateCsrfToken(request3)); // Expected: false
//
//        MockHttpServletRequest request4 = new MockHttpServletRequest();
//        String token4 = generateCsrfToken(request4);
//        MockHttpServletRequest request5 = new MockHttpServletRequest();
//        request5.setSession(request4.getSession());
//        request5.addParameter("csrfToken", token4);
//        System.out.println("Test 4: " + validateCsrfToken(request5)); // Expected: true
//
//
//        MockHttpServletRequest request6 = new MockHttpServletRequest();
//        generateCsrfToken(request6);
//        request6.addParameter("csrfToken", null);
//        System.out.println("Test 5: " + validateCsrfToken(request6)); // Expected: false
//
//
//    }
}
//
//class MockHttpServletRequest implements HttpServletRequest {
//
//    private HttpSession session;
//    private java.util.Map<String, String> parameters = new java.util.HashMap<>();
//
//    @Override
//    public HttpSession getSession() {
//        if (session == null) {
//            session = new MockHttpSession();
//        }
//        return session;
//    }
//
//    @Override
//    public HttpSession getSession(boolean create) {
//        if (create) {
//            return getSession();
//        }
//        return session;
//    }
//
//    public void setSession(HttpSession session) {
//        this.session = session;
//    }
//
//    @Override
//    public String getParameter(String name) {
//        return parameters.get(name);
//    }
//
//    public void addParameter(String name, String value) {
//        parameters.put(name, value);
//    }
//
//    // Other methods of HttpServletRequest are not needed for this example
//    // and can be left unimplemented or return default values.
//    @Override
//    public String getMethod() {
//        return null;
//    }
//    // ... other methods ...
//}
//
//class MockHttpSession implements HttpSession {
//
//    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();
//
//    @Override
//    public void setAttribute(String name, Object value) {
//        attributes.put(name, value);
//    }
//
//    @Override
//    public Object getAttribute(String name) {
//        return attributes.get(name);
//    }
//
//    // Other methods of HttpSession not needed for this example
//    // and can be left unimplemented or return default values.
//    @Override
//    public long getCreationTime() {
//        return 0;
//    }
//     // ... other methods ...
//}