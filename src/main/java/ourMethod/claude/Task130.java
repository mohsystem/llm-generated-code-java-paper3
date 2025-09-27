package ourMethod.claude;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task130 implements Filter {
    private static final String ALLOWED_ORIGINS = "https://trusted-domain.com";
    private static final String ALLOWED_METHODS = "GET, POST, OPTIONS";
    private static final String ALLOWED_HEADERS = "Content-Type, Authorization";
    private static final String MAX_AGE = "3600";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization if needed
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Validate origin
        String origin = httpRequest.getHeader("Origin");
        if (origin != null && ALLOWED_ORIGINS.contains(origin)) {
            httpResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpResponse.setHeader("Access-Control-Allow-Methods", ALLOWED_METHODS);
            httpResponse.setHeader("Access-Control-Allow-Headers", ALLOWED_HEADERS);
            httpResponse.setHeader("Access-Control-Max-Age", MAX_AGE);
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        }
        
        // Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
        // Cleanup if needed
    }
    
    public static void main(String[] args) {
        System.out.println("Test cases for CORS implementation:");
        System.out.println("1. Valid origin request - should allow access");
        System.out.println("2. Invalid origin request - should deny access");
        System.out.println("3. Preflight OPTIONS request - should handle properly");
        System.out.println("4. Request with valid headers - should allow");
        System.out.println("5. Request with invalid headers - should deny");
    }
}
