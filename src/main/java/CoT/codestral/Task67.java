package CoT.codestral;
import java.sql.*;

public class Task67 {

    public static Customer getCustomerInfo(String customerUsername) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","password");
        String query = "SELECT * FROM customer WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, customerUsername);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setEmail(rs.getString("email"));
            rs.close();
            ps.close();
            con.close();
            return customer;
        } else {
            throw new Exception("Customer not found");
        }
    }
}

class Customer {
    private int id;
    private String name;
    private String email;

    // Getters and setters for id, name, email

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}