package ZeroShot.gemini;
import java.sql.*;

public class Task67 {

    public static Customer getCustomer(String customerusername) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            // Establish database connection (replace with your database details)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");

            // Prepare SQL statement to prevent SQL injection
            String sql = "SELECT * FROM customer WHERE customerusername = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerusername);

            // Execute query
            rs = stmt.executeQuery();

            // Retrieve customer information
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerusername(rs.getString("customerusername"));
                // ... set other customer attributes
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return customer;
    }


    public static void main(String[] args) {
         if (args.length == 0) {
            System.out.println("Please provide a customer username as a command-line argument.");
            return;
        }
        String customerusername = args[0];

        Customer customer = getCustomer(customerusername);
        if (customer != null) {
            System.out.println(customer.toString());
        }
    }

}

class Customer {
    private String customerusername;
     // other fields

    public String getCustomerusername() {
        return customerusername;
    }

    public void setCustomerusername(String customerusername) {
        this.customerusername = customerusername;
    }
      // other getter and setters

    @Override
    public String toString() {
        return "Customer{" +
                "customerusername='" + customerusername + '\'' +
                '}';
    }

}