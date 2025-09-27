package ourMethod.codestral;
import java.sql.*;

public class Task67 {
    public static void main(String[] args) {
        String customerUsername = args[0];
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE customerusername = ?");
            stmt.setString(1, customerUsername);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // fetch relevant information and create structured data or object
            } else {
                System.out.println("No customer found with username: " + customerUsername);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}