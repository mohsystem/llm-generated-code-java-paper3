package CoT.openai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Task67 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task67 <customerusername>");
            return;
        }
        String customerusername = args[0];
        Customer customer = getCustomerInfo(customerusername);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static Customer getCustomerInfo(String customerusername) {
        Customer customer = null;
        String query = "SELECT * FROM customer WHERE customerusername = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, customerusername);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                customer = new Customer(rs.getString("customerusername"),
                                        rs.getString("name"),
                                        rs.getString("email"),
                                        rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}

class Customer {
    private String username;
    private String name;
    private String email;
    private String phone;

    public Customer(String username, String name, String email, String phone) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}