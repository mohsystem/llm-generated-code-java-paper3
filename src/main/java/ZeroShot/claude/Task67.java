package ZeroShot.claude;

import java.sql.*;

public class Task67 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    private static final String DB_USER = "dbuser"; 
    private static final String DB_PASSWORD = "dbpass";

    public static Customer getCustomerInfo(String customerUsername) {
        Customer customer = null;
        
        // Use try-with-resources to ensure connections are closed
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM customer WHERE username = ? LIMIT 1")) {
            
            // Use prepared statement to prevent SQL injection
            stmt.setString(1, customerUsername);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("first_name"), 
                        rs.getString("last_name"),
                        rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return null;
        }
        
        return customer;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUsernames = {
            "john_doe",
            "jane_smith", 
            "bob123",
            "alice_wong",
            "mike_jones"
        };

        for (String username : testUsernames) {
            System.out.println("Looking up customer: " + username);
            Customer result = getCustomerInfo(username);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("Customer not found");
            }
            System.out.println("-------------------");
        }
    }
}

class Customer {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(int id, String username, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
