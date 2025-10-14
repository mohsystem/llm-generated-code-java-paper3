package ourMethod.openai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task46 {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public boolean registerUser(String name, String email, String password) {
        boolean isRegistered = false;
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rowsInserted = statement.executeUpdate();
            isRegistered = rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }

    public static void main(String[] args) {
        Task46 task46 = new Task46();

        // Test cases
        System.out.println(task46.registerUser("Alice", "alice@example.com", "securePassword1"));
        System.out.println(task46.registerUser("Bob", "bob@example.com", "securePassword2"));
        System.out.println(task46.registerUser("Charlie", "charlie@example.com", "securePassword3"));
        System.out.println(task46.registerUser("David", "david@example.com", "securePassword4"));
        System.out.println(task46.registerUser("Eve", "eve@example.com", "securePassword5"));
    }
}