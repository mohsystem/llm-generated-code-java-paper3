package ourMethod.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Task49 {

    public static void main(String[] args) {
        SpringApplication.run(Task49.class, args);
    }
}

@RestController
class UserController {

    private static final String DB_URL = "jdbc:sqlite:users.db"; // Secure coding: Avoid hardcoding credentials in real applications

    @PostMapping("/users")
    public Map<String, String> createUser(@RequestBody Map<String, Object> userData) {
        Map<String, String> response = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "INSERT INTO users (name, email) VALUES (?, ?)"; // parameterized query to prevent SQL injection
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    String name = userData.get("name").toString(); // Input validation: Handle potential null or empty values
                    String email = userData.get("email").toString(); // Input validation: Sanitize email format if needed
                    pstmt.setString(1, name);
                    pstmt.setString(2, email);
                    pstmt.executeUpdate();

                    response.put("status", "success");
                    response.put("message", "User created successfully.");
                } catch (SQLException e) {
                    // Error handling: Avoid revealing sensitive information in error messages
                    response.put("status", "error");
                    response.put("message", "Error creating user. Please try again later.");
                }
            }
        } catch (SQLException e) {
            // Error handling: Log and handle exceptions appropriately
            response.put("status", "error");
            response.put("message", "Database connection error.");
        }

        return response;
    }


    // Test cases (in a real application, use a proper testing framework)
    public static void testCases() {
        UserController controller = new UserController();

        // Test case 1: Valid user data
        Map<String, Object> userData1 = new HashMap<>();
        userData1.put("name", "John Doe");
        userData1.put("email", "john.doe@example.com");
        Map<String, String> response1 = controller.createUser(userData1);
        System.out.println("Test case 1: " + response1);

        // Test case 2: Missing name
        Map<String, Object> userData2 = new HashMap<>();
        userData2.put("email", "jane.doe@example.com");
        Map<String, String> response2 = controller.createUser(userData2);
        System.out.println("Test case 2: " + response2);


        // Test case 3: Invalid email format
        Map<String, Object> userData3 = new HashMap<>();
        userData3.put("name", "Invalid User");
        userData3.put("email", "invalid-email");
        Map<String, String> response3 = controller.createUser(userData3);
        System.out.println("Test case 3: " + response3);


        // Test case 4: SQL injection attempt
        Map<String, Object> userData4 = new HashMap<>();
        userData4.put("name", "'; DROP TABLE users; --");
        userData4.put("email", "malicious@example.com");
        Map<String, String> response4 = controller.createUser(userData4);
        System.out.println("Test case 4: " + response4);


        // Test case 5: Database connection error (simulate by changing DB_URL)
        String originalDB_URL = DB_URL;
        // DB_URL = "jdbc:sqlite:invalid.db"; // uncomment to test
        Map<String, Object> userData5 = new HashMap<>();
        userData5.put("name", "Connection Error User");
        userData5.put("email", "error@example.com");
        Map<String, String> response5 = controller.createUser(userData5);
        System.out.println("Test case 5: " + response5);
        //DB_URL = originalDB_URL; // restore the original value


    }
}