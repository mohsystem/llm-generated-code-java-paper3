package CoT.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Task102 {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] hashBytes = md.digest();
        return Arrays.toString(hashBytes);
    }

    public static void updatePassword(String username, String newPassword) throws NoSuchAlgorithmException, SQLException {
        String hashedPassword = hashPassword(newPassword);

        // Database connection details (replace with your actual credentials)
        String jdbcUrl = "jdbc:your_database_url";
        String dbUsername = "your_database_username";
        String dbPassword = "your_database_password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE users SET password = ? WHERE username = ?")) {

            statement.setString(1, hashedPassword);
            statement.setString(2, username);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully for user: " + username);
            } else {
                System.out.println("User not found or password update failed.");
            }
        }
    }



    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        // Test cases
        updatePassword("user1", "new_password1");
        updatePassword("user2", "new_password2");
        updatePassword("user3", "new_password3");
        updatePassword("user4", "new_password4");
        updatePassword("user5", "new_password5");


    }
}