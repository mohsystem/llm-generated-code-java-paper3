package Vanilla.gpt4o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task37 {
    public String getUserInfo(String username) {
        String userInfo = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDB", "user", "password");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userInfo = rs.getString("info"); // Assuming there's a column named 'info'
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public static void main(String[] args) {
        Task37 task = new Task37();
        System.out.println(task.getUserInfo("testuser1"));
        System.out.println(task.getUserInfo("testuser2"));
        System.out.println(task.getUserInfo("testuser3"));
        System.out.println(task.getUserInfo("testuser4"));
        System.out.println(task.getUserInfo("testuser5"));
    }
}