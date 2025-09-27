package Vanilla.gemini;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class Task135 {

    public String generateCSRFToken() {
        return UUID.randomUUID().toString();
    }

    public boolean validateCSRFToken(HttpServletRequest request, String storedToken) {
        String requestToken = request.getParameter("csrfToken");
        return requestToken != null && requestToken.equals(storedToken);
    }


    public static void main(String[] args) {
        Task135 csrf = new Task135();

//        // Test cases
//        String token1 = csrf.generateCSRFToken();
//        System.out.println("Token 1: " + token1);
//        // Simulate request with valid token
//        System.out.println("Valid Token 1: " + csrf.validateCSRFToken(new MockHttpServletRequest("csrfToken", token1), token1));
//        // Simulate request with invalid token
//        System.out.println("Invalid Token 1: " + csrf.validateCSRFToken(new MockHttpServletRequest("csrfToken", "wrong_token"), token1));
//        // Simulate request with missing token
//        System.out.println("Missing Token 1: " + csrf.validateCSRFToken(new MockHttpServletRequest("otherParam", "some_value"), token1));
//
//        String token2 = csrf.generateCSRFToken();
//        System.out.println("Token 2: " + token2);
//        System.out.println("Valid Token 2: " + csrf.validateCSRFToken(new MockHttpServletRequest("csrfToken", token2), token2));
//
//        String token3 = csrf.generateCSRFToken();
//        System.out.println("Token 3: " + token3);
//        System.out.println("Valid Token 3: " + csrf.validateCSRFToken(new MockHttpServletRequest("csrfToken", token3), token3));



    }
//todo MockHttpServletRequest is not abstract and does not override abstract method <T>upgrade(Class<T>) in HttpServletRequest
//where T is a type-variable:
//T extends HttpUpgradeHandler declared in method <T>upgrade(Class<T>)
     static abstract class MockHttpServletRequest implements HttpServletRequest {
        private String paramName;
        private String paramValue;


        public MockHttpServletRequest(String paramName, String paramValue) {
            this.paramName = paramName;
            this.paramValue = paramValue;
        }

        @Override
        public String getParameter(String name) {
            if (name.equals(paramName)) {
                return paramValue;
            }
            return null;
        }

         @Override
         public String getMethod() {
             return null;
         }

         // Other methods of HttpServletRequest are not needed for this example, so they are not implemented

        // ... (other unimplemented methods)
    }
}