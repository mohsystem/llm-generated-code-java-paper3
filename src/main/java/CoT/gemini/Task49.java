package CoT.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;


public class Task49 extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database credentials
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Read request body
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            JSONObject json = new JSONObject(sb.toString());


            // Extract user data
            String name = json.getString("name");
            String email = json.getString("email");

            // Validate input (add more validation as needed)
            if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
                response.setStatus(400);
                response.getWriter().println("{\"error\": \"Name and email are required\"}");
                return;
            }


            // Store user data in the database
            Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)"; // Assuming 'users' table exists
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                response.setStatus(201);
                response.getWriter().println("{\"message\": \"User created successfully\"}");
            } else {
                response.setStatus(500);
                response.getWriter().println("{\"error\": \"Failed to create user\"}");
            }

            conn.close();

        } catch (SQLException e) {
            response.setStatus(500);
            response.getWriter().println("{\"error\": \"Database error: " + e.getMessage() + "\"}");
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().println("{\"error\": \"An unexpected error occurred: " + e.getMessage() + "\"}");
        }
    }


    public static void main(String[] args) {
        // Test cases (would typically use a testing framework like JUnit)
        // These tests are illustrative and would need to be adapted for a real environment
        //  (e.g., using a mock HTTP server).

        // Test case 1: Successful user creation
        // ... (Simulate POST request with valid data)

        // Test case 2: Missing required fields
        // ... (Simulate POST request with missing name or email)

        // Test case 3: Database error
        // ... (Simulate a database connection failure)

        // Test case 4: Invalid input (e.g., SQL injection attempt)
        // ... (Simulate POST request with malicious data - proper validation should prevent this)

        // Test case 5: Unexpected error
        // ... (Simulate an unexpected exception during processing)
    }
}