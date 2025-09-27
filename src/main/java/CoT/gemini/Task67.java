package CoT.gemini;
import java.sql.*;

public class Task67 {

    public static Customer getCustomer(String customerUsername, String jdbcUrl, String dbUser, String dbPassword) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE customerusername = ?")) {

            statement.setString(1, customerUsername);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Customer(
                            resultSet.getInt("id"),
                            resultSet.getString("customerusername"),
                            resultSet.getString("name"),
                            resultSet.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
         String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database URL
         String dbUser = "your_user"; // Replace with your database username
         String dbPassword = "your_password"; // Replace with your database password


        if (args.length < 1) {
            System.err.println("Please provide a customer username as a command-line argument.");
            return;
        }

        String customerUsername = args[0];

        Customer customer = getCustomer(customerUsername, jdbcUrl, dbUser, dbPassword);

        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }


    }

    private static class Customer {
        int id;
        String customerUsername;
        String name;
        String email;

        public Customer(int id, String customerUsername, String name, String email) {
            this.id = id;
            this.customerUsername = customerUsername;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", customerUsername='" + customerUsername + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}