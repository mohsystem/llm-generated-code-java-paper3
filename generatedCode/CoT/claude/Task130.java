package CoT.claude;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Task130 implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Validate origin
        String origin = request.getHeader("Origin");
        if (isValidOrigin(origin)) {
            // Set CORS headers
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Max-Age", "3600");
        }

        // Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        chain.doFilter(req, res);
    }

    private boolean isValidOrigin(String origin) {
        if (origin == null) return false;
        // Add allowed origins
        String[] allowedOrigins = {"https://trusted-domain.com", "https://another-trusted.com"};
        for (String allowed : allowedOrigins) {
            if (allowed.equals(origin)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        // Cleanup code
    }

    // Test cases
    public static void main(String[] args) {
        Task130 cors = new Task130();
        
        // Test case 1: Valid origin
        System.out.println("Test 1: " + cors.isValidOrigin("https://trusted-domain.com")); // Should return true
        
        // Test case 2: Invalid origin
        System.out.println("Test 2: " + cors.isValidOrigin("https://malicious-site.com")); // Should return false
        
        // Test case 3: Null origin
        System.out.println("Test 3: " + cors.isValidOrigin(null)); // Should return false
        
        // Test case 4: Empty origin
        System.out.println("Test 4: " + cors.isValidOrigin("")); // Should return false
        
        // Test case 5: Another valid origin
        System.out.println("Test 5: " + cors.isValidOrigin("https://another-trusted.com")); // Should return true
    }
}
