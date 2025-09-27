package ourMethod.claude;

import java.sql.*;

public class Task67 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    private static final String DB_USER = "user"; 
    private static final String DB_PASSWORD = "password";

    public static Customer getCustomerByUsername(String username) {
        Customer customer = null;
        
        // Validate input
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        // Use PreparedStatement to prevent SQL injection
        String query = "SELECT * FROM customer WHERE username = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("firstname"), 
                        rs.getString("lastname"),
                        rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred", e);
        }
        
        return customer;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide customer username as argument");
            return;
        }

        try {
            Customer customer = getCustomerByUsername(args[0]);
            if (customer != null) {
                System.out.println("Customer found: " + customer);
            } else {
                System.out.println("No customer found with username: " + args[0]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
    
    // Inner class to store customer data
    static class Customer {
        private final int id;
        private final String username;
        private final String firstname;
        private final String lastname;
        private final String email;
        
        public Customer(int id, String username, String firstname, String lastname, String email) {
            this.id = id;
            this.username = username;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
        }
        
        @Override
        public String toString() {
            return String.format("ID: %d, Username: %s, Name: %s %s, Email: %s",
                id, username, firstname, lastname, email);
        }
    }
}
