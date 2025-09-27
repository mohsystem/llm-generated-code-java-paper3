package ZeroShot.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {

    public static void updatePassword(String username, String newPassword) {
        String hashedPassword = hashPassword(newPassword);

        try (Connection connection = DriverManager.getConnection("jdbc:your_db_url", "your_db_user", "your_db_password");
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {

            statement.setString(1, hashedPassword);
            statement.setString(2, username);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hashBytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        updatePassword("user1", "new_password1");
        updatePassword("user2", "new_password2");
        updatePassword("user3", "new_password3");
        updatePassword("user4", "new_password4");
        updatePassword("user5", "new_password5");
    }
}