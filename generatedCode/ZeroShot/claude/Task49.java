package ZeroShot.claude;

import java.sql.*;
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import org.json.*;

public class Task49 {
    static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    static final String USER = "user"; 
    static final String PASS = "password";
    
    public static void main(String[] args) throws Exception {
        // Start HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/users", new UserHandler());
        server.setExecutor(null);
        server.start();
    }
    
    static class UserHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                try {
                    // Read request body
                    InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
                    BufferedReader br = new BufferedReader(isr);
                    String jsonStr = br.readLine();
                    
                    // Parse JSON
                    JSONObject json = new JSONObject(jsonStr);
                    String name = json.getString("name");
                    String email = json.getString("email");
                    
                    // Validate input
                    if (!isValidInput(name) || !isValidInput(email)) {
                        sendResponse(exchange, 400, "Invalid input");
                        return;
                    }
                    
                    // Store in database
                    if (storeUser(name, email)) {
                        sendResponse(exchange, 200, "User stored successfully");
                    } else {
                        sendResponse(exchange, 500, "Error storing user");
                    }
                    
                } catch (Exception e) {
                    sendResponse(exchange, 500, "Server error");
                }
            } else {
                sendResponse(exchange, 405, "Method not allowed");
            }
        }
        
        private boolean isValidInput(String input) {
            return input != null && !input.trim().isEmpty() && input.length() <= 100;
        }
        
        private boolean storeUser(String name, String email) {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                return false;
            }
        }
        
        private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
            exchange.sendResponseHeaders(statusCode, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    // Test cases
    public static void testAPI() {
        // Test case 1: Valid user data
        String validJson = "{\\"name\\":\\"John Doe\\",\\"email\\":\\"john@example.com\\"}";
        
        // Test case 2: Invalid name
        String invalidNameJson = "{\\"name\\":\\"\\",\\"email\\":\\"john@example.com\\"}";
        
        // Test case 3: Invalid email
        String invalidEmailJson = "{\\"name\\":\\"John Doe\\",\\"email\\":\\"\\"}";
        
        // Test case 4: Malformed JSON
        String malformedJson = "{name:John Doe}";
        
        // Test case 5: SQL injection attempt
        String sqlInjectionJson = "{\\"name\\":\\"' OR '1'='1\\",\\"email\\":\\"hack@example.com\\"}";
    }
}
