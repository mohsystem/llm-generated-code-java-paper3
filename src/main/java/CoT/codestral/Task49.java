package CoT.codestral;
// A basic example using Spring Boot and H2 database

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Task49 {
    private Map<String, String> users = new HashMap<>();

    @PostMapping("/users")
    public void createUser(@RequestBody UserO user) {
        users.put(user.getId(), user.getName());
    }

}
class UserO {
    private String id;
    private String name;
    private String email;
    private String password;

    public UserO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }
}