package Vanilla.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task49 {

    public static void storeUserData(String name, String email, int age) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:"); // Using in-memory DB for simplicity
            String sql = "CREATE TABLE IF NOT EXISTS users (name TEXT, email TEXT, age INTEGER)";
            connection.createStatement().execute(sql);

            sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, age);
            statement.executeUpdate();

            connection.close();
            System.out.println("User data stored successfully.");

        } catch (SQLException e) {
            System.err.println("Error storing user data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        storeUserData("John Doe", "john.doe@example.com", 30);
        storeUserData("Jane Smith", "jane.smith@example.com", 25);
        storeUserData("Peter Jones", "peter.jones@example.com", 40);
        storeUserData("Alice Brown", "alice.brown@example.com", 28);
        storeUserData("Bob Williams", "bob.williams@example.com", 35);


    }
}