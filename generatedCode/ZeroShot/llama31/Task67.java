package ZeroShot.llama31;
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
        Customer customer = getCustomerInfo(customerUsername);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.customerID);
            System.out.println("Customer Username: " + customer.customerUsername);
            System.out.println("Customer Name: " + customer.customerName);
            System.out.println("Customer Email: " + customer.customerEmail);
        } else {
            System.out.println("Customer not found");
        }
    }

    public static Customer getCustomerInfo(String customerUsername) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase"; // replace with your database URL
        String user = "youruser"; // replace with your database user
        String password = "yourpassword"; // replace with your database password
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE customerusername = ?")) {
            stmt.setString(1, customerUsername);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.customerID = rs.getInt("customerid");
                    customer.customerUsername = rs.getString("customerusername");
                    customer.customerName = rs.getString("customername");
                    customer.customerEmail = rs.getString("customeremail");
                    return customer;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer info: " + e.getMessage());
        }
        return null;
    }

    public static class Customer {
        public int customerID;
        public String customerUsername;
        public String customerName;
        public String customerEmail;
    }
}