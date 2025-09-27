package ourMethod.gemini;
import java.sql.*;

public class Task67 {

    public static Customer getCustomerInfo(String customerUsername) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            // Establish database connection (replace with your database credentials)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");

            // Prepare SQL statement with parameterized query to prevent SQL injection
            String sql = "SELECT * FROM customer WHERE customerusername = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customerUsername);


            // Execute query
            resultSet = statement.executeQuery();

            // Retrieve customer information
            if (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerUsername(resultSet.getString("customerusername"));
                customer.setCustomerName(resultSet.getString("customername"));
                // Set other customer attributes as needed
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving customer information: " + e.getMessage());
        } finally {
            // Close resources in reverse order
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }

        return customer;
    }

    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"testuser1", "testuser2", "invaliduser", "anotheruser", "testuser3"};

        for (String username : usernames) {
            Customer customer = getCustomerInfo(username);
            if (customer != null) {
                System.out.println("Customer Information for " + username + ":");
                System.out.println(customer);
            } else {
                System.out.println("Customer not found for username: " + username);
            }
            System.out.println();
        }


    }

}

class Customer {
    private String customerUsername;
    private String customerName;
    // other customer fields

    // Getters and setters

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    @Override
    public String toString() {
        return "CustomerUsername: " + customerUsername + ", CustomerName: " + customerName;
    }
}