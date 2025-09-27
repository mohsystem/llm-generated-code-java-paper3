package Vanilla.llama31;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatePassword(String username, String newPassword, String dbUrl, String dbUser, String dbPassword) {
        String hashedPassword = hashPassword(newPassword);
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {
            stmt.setString(1, hashedPassword);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUser = "myuser";
        String dbPassword = "mypassword";
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String newPassword = "newpassword";

        for (String username : usernames) {
            updatePassword(username, newPassword, dbUrl, dbUser, dbPassword);
        }
    }
}