package Vanilla.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {

    public static void updatePassword(String username, String newPassword) {
        String hashedPassword = hashPassword(newPassword);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
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
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
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