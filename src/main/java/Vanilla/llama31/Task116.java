package Vanilla.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task116 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";
        String userToModify = "example_user";
        String host = "%";
        String newPassword = "new_password";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            // Change password
            String changePasswordQuery = "ALTER USER ?@? IDENTIFIED BY ?";
            PreparedStatement stmt = conn.prepareStatement(changePasswordQuery);
            stmt.setString(1, userToModify);
            stmt.setString(2, host);
            stmt.setString(3, newPassword);
            stmt.executeUpdate();

            // Drop user privileges
            String dropPrivilegesQuery = "REVOKE ALL ON mydb.* FROM ?@?";
            stmt = conn.prepareStatement(dropPrivilegesQuery);
            stmt.setString(1, userToModify);
            stmt.setString(2, host);
            stmt.executeUpdate();

            // Drop user
            String dropUserQuery = "DROP USER ?@?";
            stmt = conn.prepareStatement(dropUserQuery);
            stmt.setString(1, userToModify);
            stmt.setString(2, host);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}