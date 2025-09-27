package ZeroShot.codestral;
// Java
import java.sql.*;

public class Task37 {
    public static void main(String[] args) {
        getUserInfo("test_user");
    }

    public static void getUserInfo(String username) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}