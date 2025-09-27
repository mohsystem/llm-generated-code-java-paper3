package ourMethod.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Task67 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task67 <customerusername>");
            return;
        }
        String customerUsername = args[0];
        Map<String, String> customerInfo = getCustomerInfo(customerUsername);
        if (customerInfo != null) {
            System.out.println(customerInfo);
        } else {
            System.out.println("Customer not found");
        }
    }

    public static Map<String, String> getCustomerInfo(String customerUsername) {
        Map<String, String> customerInfo = new HashMap<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "youruser", "yourpassword");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE customerusername = ?")) {
            stmt.setString(1, customerUsername);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customerInfo.put("customerusername", rs.getString("customerusername"));
                    customerInfo.put("name", rs.getString("name"));
                    customerInfo.put("email", rs.getString("email"));
                    // Add other fields as needed
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return customerInfo;
    }
}