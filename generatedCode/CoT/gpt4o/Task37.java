package CoT.openai;
import java.sql.*;

public class Task37 {
    public static String getUserInfo(String username) {
        String result = "";
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_user";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        result += rs.getString("username") + ": " + rs.getString("info") + "\n";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getUserInfo("user1"));
        System.out.println(getUserInfo("user2"));
        System.out.println(getUserInfo("user3"));
        System.out.println(getUserInfo("user4"));
        System.out.println(getUserInfo("user5"));
    }
}