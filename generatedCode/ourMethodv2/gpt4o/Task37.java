import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task37 {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdbname";
    private static final String USER = "yourusername";
    private static final String PASS = "yourpassword";

    public static String getUserInfo(String username) {
        String result = "";
        String query = "SELECT * FROM users WHERE username = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = "User found: " + rs.getString("username");
                } else {
                    result = "User not found";
                }
            }
        } catch (SQLException e) {
            result = "Error: " + e.getMessage();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getUserInfo("alice"));
        System.out.println(getUserInfo("bob"));
        System.out.println(getUserInfo("charlie"));
        System.out.println(getUserInfo("dave"));
        System.out.println(getUserInfo("eve"));
    }
}