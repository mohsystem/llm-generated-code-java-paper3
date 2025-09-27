package ourMethod.gemini;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task130 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String origin = request.getHeader("Origin");

        if (origin != null && (origin.equals("https://www.example.com") || origin.equals("http://localhost:8080"))) {  // Whitelisted origins
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // Allowed methods
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Allowed headers
            response.setHeader("Access-Control-Allow-Credentials", "true"); // Allow credentials
            response.setHeader("Vary", "Origin"); // Include Origin in the Vary header
        }


        // API Implementation
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"CORS enabled API response\"}");
    }


        // API Implementation for preflight requests
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String origin = request.getHeader("Origin");

                if (origin != null && (origin.equals("https://www.example.com") || origin.equals("http://localhost:8080"))) {  // Whitelisted origins
                    response.setHeader("Access-Control-Allow-Origin", origin);
                    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
                    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
                    response.setHeader("Access-Control-Allow-Credentials", "true");
                    response.setHeader("Vary", "Origin");
                }
                response.setStatus(HttpServletResponse.SC_OK);


    }



    public static void main(String[] args) throws Exception {

        //  Test cases (These would typically be run in a test environment, not main)
        //  You'd need a way to simulate requests and check responses,
        //  e.g., using a testing framework like JUnit and a mock servlet container.


        // Example (Illustrative only - doesn't actually execute):
        //  String origin1 = "https://www.example.com";
        //  HttpServletRequest request1 = mockRequestWithOrigin(origin1);  // (mock function not defined here)
        //  HttpServletResponse response1 = mockResponse(); // (mock function not defined here)
        //  new Task130().doGet(request1, response1);
        //  assert response1.getHeader("Access-Control-Allow-Origin").equals(origin1);

        // ...similarly for other test cases with different origins, methods, headers...
        // Test cases
        // Test case 1: Valid origin
        // Test case 2: Invalid origin
        // Test case 3: Preflight request
        // Test case 4: Request with credentials
        // Test case 5: Request with disallowed method

    }
}