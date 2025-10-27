package CoT.claude;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.sql.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class Task49 {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    
    public static void main(String[] args) throws Exception {
        // Initialize database
        initializeDB();
        
        // Create HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/users", new UserHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
        
        // Test cases
        testUserAPI();
    }
    
    static class UserHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                // Read request body
                String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                
                // Validate input
                if (!isValidInput(requestBody)) {
                    sendResponse(exchange, 400, "Invalid input");
                    return;
                }
                
                try {
                    // Store in database
                    storeUser(requestBody);
                    sendResponse(exchange, 200, "User stored successfully");
                } catch (SQLException e) {
                    sendResponse(exchange, 500, "Database error");
                }
            } else {
                sendResponse(exchange, 405, "Method not allowed");
            }
        }
    }
    
    private static void initializeDB() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users " +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " data TEXT NOT NULL)";
            stmt.execute(sql);
        }
    }
    
    private static void storeUser(String userData) throws SQLException {
        String sql = "INSERT INTO users (data) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userData);
            pstmt.executeUpdate();
        }
    }
    
    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
    
    private static boolean isValidInput(String input) {
        // Basic input validation
        return input != null && 
               input.length() <= 1000 && 
               Pattern.matches("^[a-zA-Z0-9\\\\s\\\\{\\\\}\\\\"\\\\:\\\\,]*$", input);
    }
    
    private static void testUserAPI() {
        // Test cases would typically be implemented here
        // In a real application, you would use HTTP client to test the API
        System.out.println("Test cases:");
        System.out.println("1. Valid user data");
        System.out.println("2. Invalid input (special characters)");
        System.out.println("3. Empty input");
        System.out.println("4. Too long input");
        System.out.println("5. Non-POST request");
    }
}
