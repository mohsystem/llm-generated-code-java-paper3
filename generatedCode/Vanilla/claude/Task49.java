package Vanilla.claude;

// Java - Basic example using Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Task49 {
    public static void main(String[] args) {
        SpringApplication.run(Task49.class, args);
    }
}

@RestController
class UserController {
    private List<User> users = new ArrayList<>();
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }
}

class User {
    private String name;
    private String email;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
