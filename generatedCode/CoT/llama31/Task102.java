package CoT.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import org.mindrot.jbcrypt.BCrypt;

public class Task102 {
    private Connection conn;

    public Task102(String dbName) throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        conn.prepareStatement("CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT)").execute();
    }

    public void hashAndUpdatePassword(String username, String newPassword) throws SQLException {
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        PreparedStatement ps = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
        ps.setString(1, hashedPassword);
        ps.setString(2, username);
        ps.executeUpdate();
    }

    public void addUser(String username, String password) throws SQLException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        PreparedStatement ps = conn.prepareStatement("INSERT OR REPLACE INTO users VALUES (?, ?)");
        ps.setString(1, username);
        ps.setString(2, hashedPassword);
        ps.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String dbName = "users.db";
        String[] testUsernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] testPasswords = {"password1", "password2", "password3", "password4", "password5"};

        try (Task102 task = new Task102(dbName)) {
            for (int i = 0; i < testUsernames.length; i++) {
                task.addUser(testUsernames[i], testPasswords[i]);
                System.out.println("User " + testUsernames[i] + " added with hashed password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}