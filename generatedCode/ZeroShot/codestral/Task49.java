package ZeroShot.codestral;
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