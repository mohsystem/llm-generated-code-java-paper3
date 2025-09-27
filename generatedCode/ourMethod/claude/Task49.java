package ourMethod.claude;

// Task49.java
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.sql.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class Task49 {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    
    public static void main(String[] args) throws Exception {
        // Initialize database
        initializeDatabase();
        
        // Create HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/users", new UserHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }
    
    static class UserHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                if (!"POST".equals(exchange.getRequestMethod())) {
                    sendResponse(exchange, 405, "Method Not Allowed");
                    return;
                }

                // Read request body
                String requestBody = readRequestBody(exchange.getRequestBody());
                
                // Validate input
                if (!isValidUserData(requestBody)) {
                    sendResponse(exchange, 400, "Invalid input data");
                    return;
                }
                
                // Store in database
                boolean success = storeUserData(requestBody);
                
                if (success) {
                    sendResponse(exchange, 200, "User data stored successfully");
                } else {
                    sendResponse(exchange, 500, "Failed to store user data");
                }
                
            } catch (Exception e) {
                sendResponse(exchange, 500, "Internal Server Error");
            }
        }
        
        private String readRequestBody(InputStream inputStream) throws IOException {
            StringBuilder body = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                body.append(new String(buffer, 0, length, StandardCharsets.UTF_8));
            }
            return body.toString();
        }
        
        private boolean isValidUserData(String data) {
            if (data == null || data.trim().isEmpty()) {
                return false;
            }
            // Add more validation as per requirements
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\\\s,.:@-]{1,100}$");
            return pattern.matcher(data).matches();
        }
        
        private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(statusCode, response.getBytes(StandardCharsets.UTF_8).length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
    
    private static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT NOT NULL)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean storeUserData(String data) {
        String sql = "INSERT INTO users (data) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, data);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Test cases
    public static void testAPI() {
        // Test case 1: Valid input
        String validInput = "John Doe, john@example.com";
        assert isValidUserData(validInput);

        // Test case 2: Empty input
        String emptyInput = "";
        assert !isValidUserData(emptyInput);

        // Test case 3: SQL injection attempt
        String sqlInjection = "'); DROP TABLE users; --";
        assert !isValidUserData(sqlInjection);

        // Test case 4: XSS attempt
        String xssAttempt = "<script>alert('xss')</script>";
        assert !isValidUserData(xssAttempt);

        // Test case 5: Oversized input
        String oversizedInput = "a".repeat(1000);
        assert !isValidUserData(oversizedInput);
    }
}
