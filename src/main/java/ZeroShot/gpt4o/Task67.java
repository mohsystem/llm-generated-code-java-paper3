package ZeroShot.gpt4o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task67 {
    public static class Customer {
        private String username;
        private String name;
        private String email;

        public Customer(String username, String name, String email) {
            this.username = username;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Customer{username='" + username + "', name='" + name + "', email='" + email + "'}";
        }
    }

    public static Customer getCustomerInfo(String customerUsername) {
        Customer customer = null;
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        String query = "SELECT username, name, email FROM customer WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, customerUsername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String email = rs.getString("email");
                customer = new Customer(username, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static void main(String[] args) {
        String[] testUsernames = {"user1", "user2", "user3", "user4", "user5"};
        for (String username : testUsernames) {
            Customer customer = getCustomerInfo(username);
            System.out.println(customer);
        }
    }
}