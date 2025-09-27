package ZeroShot.codestral;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {
    public static void main(String[] args) {
        updatePassword("user1", "newPassword");
    }

    public static void updatePassword(String username, String newPassword) {
        String hashedPassword = hashPassword(newPassword);
        if (hashedPassword != null) {
            //todo cannot find symbol variable DatabaseConnection
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "UPDATE users SET password = ? WHERE username = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, hashedPassword);
                statement.setString(2, username);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Password updated successfully");
                } else {
                    System.out.println("User not found");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static class DatabaseConnection {
        public static Connection getConnection() {
            return null;
        }
    }
}