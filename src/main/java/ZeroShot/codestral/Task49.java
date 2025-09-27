package ZeroShot.codestral;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Java with Spring Boot
@RestController
@RequestMapping("/api")
public class Task49 {
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // Save user to database
        return ResponseEntity.ok("User created");
    }
}