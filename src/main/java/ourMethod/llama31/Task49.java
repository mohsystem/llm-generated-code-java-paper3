package ourMethod.llama31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class Task49 {

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "username", "password")) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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