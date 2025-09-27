package CoT.gemini;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Task130 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String origin = request.getHeader("Origin");

        if (origin != null && (origin.equals("https://allowed-origin.com") || origin.equals("http://localhost:8080"))) {  // Whitelist allowed origins
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // Allowed HTTP methods
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Allowed headers
            response.setHeader("Access-Control-Allow-Credentials", "true"); // Allow credentials (cookies, authorization headers)
        }

        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"CORS enabled response\"}");
    }


    public static void main(String[] args) throws Exception {
        // Test cases would involve deploying this servlet to a web server
        // and making requests from different origins to verify the CORS headers.
        // This is beyond the scope of a simple code example.
        System.out.println("Servlet needs to be deployed to test.");
        System.out.println("Example Test Cases (Manual testing required):");
        System.out.println("1. Origin: https://allowed-origin.com (Expect success)");
        System.out.println("2. Origin: http://localhost:8080 (Expect success)");
        System.out.println("3. Origin: https://malicious-site.com (Expect failure)");
        System.out.println("4. Origin: null (Expect no CORS headers, may succeed depending on browser)");
        System.out.println("5. Preflight OPTIONS request (Check for Access-Control-Allow-Headers and Access-Control-Allow-Methods)");
    }
}