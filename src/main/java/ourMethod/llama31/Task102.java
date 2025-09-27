package ourMethod.llama31;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        String hashedPassword = hashPassword(newPassword);
        updatePasswordInDatabase(username, hashedPassword);
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static void updatePasswordInDatabase(String username, String hashedPassword) {
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "your_username";
        String dbPassword = "your_password";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {

            stmt.setString(1, hashedPassword);
            stmt.setString(2, username);
            stmt.executeUpdate();
            System.out.println("Password updated successfully.");

        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
    }
}