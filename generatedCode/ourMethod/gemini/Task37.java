package ourMethod.gemini;
import java.sql.*;
import java.util.Scanner;

public class Task37 {

    public static ResultSet getUserInfo(String username, String connectionUrl, String user, String password) throws SQLException {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password)) {
            String query = "SELECT * FROM users WHERE username = ?"; // Parameterized query to prevent SQL injection
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet;
                }
            }
        }
    }


    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://your_server_name;databaseName=your_database_name;encrypt=true;trustServerCertificate=true;";
        String user = "your_username";
        String password = "your_password";

        Scanner scanner = new Scanner(System.in);


        try {
            System.out.print("Enter username 1: ");
            String username1 = scanner.nextLine();
            ResultSet rs1 = getUserInfo(username1, connectionUrl, user, password);
            while (rs1.next()) {
                System.out.println(rs1.getString("username") + " " + rs1.getString("email"));
            }

            System.out.print("Enter username 2: ");
            String username2 = scanner.nextLine();
            ResultSet rs2 = getUserInfo(username2, connectionUrl, user, password);
            while (rs2.next()) {
                System.out.println(rs2.getString("username") + " " + rs2.getString("email"));
            }

            System.out.print("Enter username 3: ");
            String username3 = scanner.nextLine();
            ResultSet rs3 = getUserInfo(username3, connectionUrl, user, password);
            while (rs3.next()) {
                System.out.println(rs3.getString("username") + " " + rs3.getString("email"));
            }

            System.out.print("Enter username 4: ");
            String username4 = scanner.nextLine();
            ResultSet rs4 = getUserInfo(username4, connectionUrl, user, password);
            while (rs4.next()) {
                System.out.println(rs4.getString("username") + " " + rs4.getString("email"));
            }

            System.out.print("Enter username 5: ");
            String username5 = scanner.nextLine();
            ResultSet rs5 = getUserInfo(username5, connectionUrl, user, password);
            while (rs5.next()) {
                System.out.println(rs5.getString("username") + " " + rs5.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }



    }
}