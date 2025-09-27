package Vanilla.codestral;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {
    public static void updatePassword(String username, String newPassword) {
        String hashedPassword = hashPassword(newPassword);
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUsername = "root";
        String dbPassword = "password";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, hashedPassword);
            statement.setString(2, username);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("No user found with the provided username.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while updating the password.");
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("An error occurred while hashing the password.");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        updatePassword("user1", "newPassword1");
        updatePassword("user2", "newPassword2");
        updatePassword("user3", "newPassword3");
        updatePassword("user4", "newPassword4");
        updatePassword("user5", "newPassword5");
    }
}