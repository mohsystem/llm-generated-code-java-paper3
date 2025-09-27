package ZeroShot.llama31;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
@RestController
public class Task49 {

    public static void main(String[] args) {
        SpringApplication.run(Task49.class, args);
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody User user) {
        // Simulate saving to database
        System.out.println("Saving user: " + user.getName() + " " + user.getEmail());
        return "User saved";
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