package Vanilla.codestral;
import java.sql.*;

public class Task67 {
    public static void main(String[] args) {
        try {
            System.out.println(getCustomerInfo(args[0]));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getCustomerInfo(String customerUsername) throws SQLException {
        // Assuming you have a connection to your database
        Connection conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE username = ?");
        stmt.setString(1, customerUsername);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Assuming you have columns "name" and "email" in your customer table
            return "Name: " + rs.getString("name") + ", Email: " + rs.getString("email");
        } else {
            return "No customer found with username: " + customerUsername;
        }
    }
}