package CoT.llama31;
// Task49.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
@RestController
public class Task49 {

    public static void main(String[] args) {
        SpringApplication.run(Task49.class, args);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
            return "User created successfully";
        } catch (SQLException e) {
            return "Error creating user: " + e.getMessage();
        }
    }

    public static class User {
        private String name;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}