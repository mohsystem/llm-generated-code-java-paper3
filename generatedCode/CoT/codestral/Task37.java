package CoT.codestral;
import java.sql.*;

public class Task37 {
    public static void main(String[] args) {
        getUserInfo("testUser");
    }

    public static void getUserInfo(String username) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String user = "username";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}