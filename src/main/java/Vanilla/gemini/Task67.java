package Vanilla.gemini;
import java.sql.*;

public class Task67 {

    public static Customer getCustomer(String customerUsername) {
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE customerusername = ?")) {

            statement.setString(1, customerUsername);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    customer = new Customer(resultSet.getInt("id"), resultSet.getString("customerusername"),
                            resultSet.getString("name"), resultSet.getString("email")); // Adapt to your columns
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please provide a customer username as a command-line argument.");
            return;
        }

        String customerUsername = args[0];
        Customer customer = getCustomer(customerUsername);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static class Customer {
        int id;
        String customerusername;
        String name;
        String email;


        public Customer(int id, String customerusername, String name, String email) {
            this.id = id;
            this.customerusername = customerusername;
            this.name = name;
            this.email = email;
        }


        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", customerusername='" + customerusername + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

}