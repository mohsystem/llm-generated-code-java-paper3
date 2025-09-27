package ourMethod.codestral;
import java.sql.*;

public class Task37 {
    private static final String DB_URL = "jdbc:mysql://localhost/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        String username = "testuser"; // replace with user input
        String sql = "SELECT * FROM Users WHERE Username = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("Username") + ", " + rs.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}