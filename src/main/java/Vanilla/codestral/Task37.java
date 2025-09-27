package Vanilla.codestral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task37 {

    private static final String DB_URL = "jdbc:postgresql://your_host/your_database";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void getUserInfo(String username) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM your_table WHERE username = ?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getUserInfo("testUser");
    }
}