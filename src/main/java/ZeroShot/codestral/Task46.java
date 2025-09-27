package ZeroShot.codestral;
import java.sql.*;

public class Task46 {
    public static void registerUser(String name, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String dbUser = "username";
        String dbPassword = "password";

        try {
            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, email);
            preparedStmt.setString(3, password); // Make sure you're hashing this password
            preparedStmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        registerUser("John Doe", "john.doe@example.com", "password123");
    }
}