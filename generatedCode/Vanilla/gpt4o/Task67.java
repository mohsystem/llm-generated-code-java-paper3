package Vanilla.openai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task67 {

    public static class Customer {
        private String username;
        private String name;
        private String email;

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
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_user";
        String password = "your_password";
        String query = "SELECT username, name, email FROM customer WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customerUsername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(rs.getString("username"), rs.getString("name"), rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a customer username.");
            return;
        }

        Customer customer = getCustomerInfo(args[0]);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}