package CoT.codestral;
// A basic example using Spring Boot and H2 database

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private Map<String, String> users = new HashMap<>();

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        users.put(user.getId(), user.getName());
    }
}