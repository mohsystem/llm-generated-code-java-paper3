package Vanilla.gemini;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Task130 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.addHeader("Access-Control-Allow-Origin", "*"); // Allow all origins
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.getWriter().println("CORS enabled response");
    }

    public static void main(String[] args) {
        // Test cases would typically involve deploying the servlet and making requests from different origins
        // to verify the CORS headers are present and functional.  This cannot be demonstrated within
        // a simple main method.  See comments below.

        // Test case 1: Access from same origin (should succeed without CORS)
        // Test case 2: Access from different origin (should succeed due to CORS headers)
        // Test case 3: Preflight request (OPTIONS) - check for appropriate CORS headers
        // Test case 4: Request with custom headers - check for Access-Control-Allow-Headers
        // Test case 5: Request with cookies - include "withCredentials" in request and 
        //               "Access-Control-Allow-Credentials: true" in response if needed
    }
}