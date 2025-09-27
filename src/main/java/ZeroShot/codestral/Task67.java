package ZeroShot.codestral;
import java.sql.*;

public class Task67 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a customer username as a command line argument.");
            return;
        }

        String customerUsername = args[0];
        try {
            Customer customer = getCustomerInfo(customerUsername);
            if (customer != null) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Customer Email: " + customer.getEmail());
                // print other fields as needed
            } else {
                System.out.println("No customer found with the username: " + customerUsername);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Customer getCustomerInfo(String customerUsername) throws SQLException {
        // replace with your database credentials
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "username";
        String password = "password";

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE username = ?");
        stmt.setString(1, customerUsername);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setEmail(rs.getString("email"));
            // set other fields as needed
            return customer;
        } else {
            return null;
        }
    }

    static class Customer {
        private int id;
        private String name;
        private String email;
//todo cannot find symbol method getId()
//cannot find symbol method getName()
//cannot find symbol method getEmail()
//cannot find symbol method setId(int)
//cannot find symbol method setName(String)
//cannot find symbol method setEmail(String)
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
        // getters and setters for all fields
    }
}