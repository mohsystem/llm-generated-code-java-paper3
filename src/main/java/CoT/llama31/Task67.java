package CoT.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task67 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task67 <customerusername>");
            return;
        }
        String customerUsername = args[0];
        Customer customer = getCustomerInformation(customerUsername);
        if (customer != null) {
            System.out.println("Customer Information:");
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static Customer getCustomerInformation(String customerUsername) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "youruser";
        String password = "yourpassword";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE username = ?")) {

            stmt.setString(1, customerUsername);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setUsername(rs.getString("username"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    return customer;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public static class Customer {
        private String username;
        private String name;
        private String email;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}