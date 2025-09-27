package CoT.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


    public static void main(String[] args) {
        // Test cases (Simulated HttpServletRequest and HttpSession would be needed for realistic testing)
        // In a real application, these would be within a Servlet or similar context

        // Test 1: Generate and verify
        TestHttpServletRequest request1 = new TestHttpServletRequest();
        TestHttpSession session1 = new TestHttpSession();
        request1.setSession(session1);
        String token1 = generateCsrfToken(request1);
        request1.setParameter("csrfToken", token1);
        boolean valid1 = verifyCsrfToken(request1);
        System.out.println("Test 1: " + valid1); // Expected: true

        // Test 2: Invalid token
        TestHttpServletRequest request2 = new TestHttpServletRequest();
        TestHttpSession session2 = new TestHttpSession();
        request2.setSession(session2);
        generateCsrfToken(request2); 
        request2.setParameter("csrfToken", "invalid_token");
        boolean valid2 = verifyCsrfToken(request2);
        System.out.println("Test 2: " + valid2); // Expected: false

        // Test 3: No token in request
        TestHttpServletRequest request3 = new TestHttpServletRequest();
        TestHttpSession session3 = new TestHttpSession();
        request3.setSession(session3);
        generateCsrfToken(request3);
        boolean valid3 = verifyCsrfToken(request3);
        System.out.println("Test 3: " + valid3); // Expected: false

         // Test 4: Double submit (replay attack)
        TestHttpServletRequest request4 = new TestHttpServletRequest();
        TestHttpSession session4 = new TestHttpSession();
        request4.setSession(session4);
        String token4 = generateCsrfToken(request4);
        request4.setParameter("csrfToken", token4);
        verifyCsrfToken(request4); // First valid submission
        request4.setParameter("csrfToken", token4); // Resubmitting same token
        boolean valid4 = verifyCsrfToken(request4); 
        System.out.println("Test 4: " + valid4); // Expected: false

        // Test 5: No session
        TestHttpServletRequest request5 = new TestHttpServletRequest();
        boolean valid5 = verifyCsrfToken(request5);
        System.out.println("Test 5: " + valid5); // Expected: false
    }

    // Mock/stub classes for testing (replace with real HttpServletRequest/HttpSession)
    static class TestHttpServletRequest extends HttpServletRequestWrapper {
        private java.util.Map<String, String> params = new java.util.HashMap<>();
        private HttpSession session;
        public TestHttpServletRequest() {
            super(null); // Not a real request, just for testing
        }
        public String getParameter(String name) { return params.get(name); }
        public void setParameter(String name, String value) { params.put(name, value); }
        public HttpSession getSession() { return session;}
        public void setSession(HttpSession session) { this.session = session;}

        public TestHttpServletRequest(HttpServletRequest request) {
            super(request);
        }

    }

    static class TestHttpSession implements HttpSession {
        private java.util.Map<String, Object> attributes = new java.util.HashMap<>();
        public Object getAttribute(String name) { return attributes.get(name); }
        public void setAttribute(String name, Object value) { attributes.put(name, value); }
        public void removeAttribute(String name) { attributes.remove(name); }
        // ... other required methods (can be left empty for this example) ...
        public long getCreationTime() {return 0;}
        public String getId() {return null;}
        public long getLastAccessedTime() {return 0;}
        public ServletContext getServletContext() {return null;}
        public void setMaxInactiveInterval(int interval) {}
        public int getMaxInactiveInterval() {return 0;}


        public HttpSessionContext getSessionContext() {return null;}
        public Object getValue(String name) {return null;}
        public String[] getValueNames() {return null;}
        public void putValue(String name, Object value) {}
        public void removeValue(String name) {}
        public void invalidate() {}
        public boolean isNew() {return false;}
    }

}



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;