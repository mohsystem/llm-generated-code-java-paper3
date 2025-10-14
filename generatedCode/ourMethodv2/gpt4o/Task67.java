import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.nio.charset.StandardCharsets;

public class Task67 {

    public static class Customer {
        private final String username;
        private final String name;
        private final String email;

        public Customer(String username, String name, String email) {
            this.username = username;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "username='" + username + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    public static Customer getCustomerInfo(String customerUsername) {
        String url = "jdbc:yourdatabaseurl";
        String user = "yourdbuser";
        String password = "yourdbpassword";
        String query = "SELECT username, name, email FROM customer WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, customerUsername);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    return new Customer(username, name, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task67 <customerusername>");
            return;
        }

        String customerUsername = new String(args[0].getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        Customer customer = getCustomerInfo(customerUsername);
        
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}