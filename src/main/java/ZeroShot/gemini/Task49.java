package ZeroShot.gemini;
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

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database details
    private static final String DB_USER = "your_username"; // Replace with your database credentials
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
            JSONObject userData = new JSONObject(sb.toString());

            // Store in database
            storeUserData(userData);

            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (SQLException | IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("Error: " + e.getMessage());
        }
    }



    private void storeUserData(JSONObject userData) throws SQLException, IllegalArgumentException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {

             String name = userData.optString("name", null);
             String email = userData.optString("email", null);

             if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
                 throw new IllegalArgumentException("Name and email are required.");
             }

             stmt.setString(1, name);
             stmt.setString(2, email);

             stmt.executeUpdate();

        }
    }


    public static void main(String[] args) throws SQLException, IOException {

    }
}