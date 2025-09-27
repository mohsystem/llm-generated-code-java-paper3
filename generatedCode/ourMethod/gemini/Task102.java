package ourMethod.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] byteData = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte byteDatum : byteData) {
            sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static boolean updatePassword(String username, String newPassword) throws NoSuchAlgorithmException, SQLException {
        String hashedPassword = hashPassword(newPassword);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_db_user", "your_db_password");
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {
            statement.setString(1, hashedPassword);
            statement.setString(2, username);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Handle potential exceptions like SQL injection or invalid usernames
            System.err.println("Error updating password: " + e.getMessage());
            return false;
        }


    }

    public static void main(String[] args) {
        try {
            // Test cases
            System.out.println("Password updated: " + updatePassword("testuser1", "P@$$wOrd"));
            System.out.println("Password updated: " + updatePassword("testuser2", "MySecret"));
            System.out.println("Password updated: " + updatePassword("testuser3", "AnotherPassword"));
            System.out.println("Password updated: " + updatePassword("testuser4", "123456"));
            System.out.println("Password updated: " + updatePassword("testuser5", "ComplexP@$$"));

        } catch (NoSuchAlgorithmException | SQLException e) {
            System.err.println("Error during test cases: " + e.getMessage());
        }
    }
}