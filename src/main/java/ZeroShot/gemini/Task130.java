package ZeroShot.gemini;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Task130 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String origin = request.getHeader("Origin");

        if (origin != null && (origin.equals("https://allowed-origin.com") || origin.equals("http://localhost:8080"))) {
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
            response.setHeader("Access-Control-Max-Age", "3600"); // Cache preflight response for 1 hour
        }

        response.setContentType("application/json");
        response.getWriter().println("{\"message\": \"API response\"}");
    }


    public static void main(String[] args) throws Exception {
        //  This requires setting up a servlet container to test these cases properly.
        //  These tests are illustrative, showcasing how to make requests and expected CORS behavior.

        // Test 1: Request from allowed origin
        // Request from https://allowed-origin.com should succeed

        // Test 2: Request from disallowed origin
        // Request from https://disallowed-origin.com should fail

        // Test 3: Preflight request
        //  OPTIONS request from https://allowed-origin.com with specific headers should succeed

        // Test 4: Request with credentials
        // Request with credentials from https://allowed-origin.com should succeed if Access-Control-Allow-Credentials is set

        // Test 5: Invalid preflight request
        // OPTIONS request with disallowed headers should fail

        System.out.println("Testing requires a web server and actual HTTP requests.");

    }
}