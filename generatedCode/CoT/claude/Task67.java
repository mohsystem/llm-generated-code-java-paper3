package CoT.claude;

import java.sql.*;

public class Task67 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
    private static final String USER = "dbuser";
    private static final String PASS = "dbpassword";
    
    public static Customer getCustomerInfo(String username) {
        Customer customer = null;
        
        // Input validation
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        // SQL using prepared statement to prevent SQL injection
        String sql = "SELECT * FROM customer WHERE customerusername = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("customerusername"),
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
            // Test cases
            String[] testUsernames = {
                args[0],
                "john_doe",
                "jane_smith", 
                "invalid_user",
                "test_user"
            };
            
            for (String username : testUsernames) {
                try {
                    Customer customer = getCustomerInfo(username);
                    if (customer != null) {
                        System.out.println("Customer found: " + customer);
                    } else {
                        System.out.println("No customer found for username: " + username);
                    }
                } catch (Exception e) {
                    System.out.println("Error processing username " + username + ": " + e.getMessage());
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
        return "Customer{id=" + id + 
               ", username='" + username + '\\'' +
               ", firstName='" + firstName + '\\'' +
               ", lastName='" + lastName + '\\'' +
               ", email='" + email + '\\'' +
               '}';
    }
}
