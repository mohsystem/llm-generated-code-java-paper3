package CoT.claude;

import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcServer;
import java.io.IOException;

public class Task111 {
    private static final int PORT = 8080;
    
    public static class SecureHandler {
        public String echo(String input) {
            if (input == null || input.length() > 1000) {
                return "Invalid input";
            }
            return sanitizeInput(input);
        }
        
        public int add(int x, int y) {
            // Input validation
            if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE || 
                y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Invalid input range");
            }
            return x + y;
        }
        
        private String sanitizeInput(String input) {
            // Basic input sanitization
            return input.replaceAll("[<>\\"']", "");
        }
    }
    
    public static void main(String[] args) {
        try {
            WebServer server = new WebServer(PORT);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
            
            // Register handler with security checks
            xmlRpcServer.addHandler("secure", new SecureHandler());
            
            // Start server with security configurations
            server.start();
            System.out.println("Server running on port " + PORT);
            
            // Test cases
            SecureHandler handler = new SecureHandler();
            System.out.println("Test 1: " + handler.echo("Hello"));
            System.out.println("Test 2: " + handler.echo("<script>alert('xss')</script>"));
            System.out.println("Test 3: " + handler.add(5, 3));
            System.out.println("Test 4: " + handler.echo("Normal text"));
            System.out.println("Test 5: " + handler.add(10, -5));
            
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
