package Vanilla.claude;

import java.sql.*;

public class Task67 {
    public static Customer getCustomerInfo(String customerUsername) {
        Customer customer = null;
        String url = "jdbc:mysql://localhost:3306/customerdb";
        String user = "root";
        String password = "password";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customerUsername);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setUsername(rs.getString("username")); 
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testUsernames = {
            "john123",
            "mary456", 
            "peter789",
            "sarah321",
            "mike654"
        };
        
        for(String username : testUsernames) {
            Customer customer = getCustomerInfo(username);
            if(customer != null) {
                System.out.println("Customer found:");
                System.out.println("ID: " + customer.getId());
                System.out.println("Username: " + customer.getUsername());
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());
            } else {
                System.out.println("No customer found with username: " + username);
            }
            System.out.println("------------------------");
        }
    }
}

class Customer {
    private int id;
    private String username;
    private String name;
    private String email;
    private String phone;
    
    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
