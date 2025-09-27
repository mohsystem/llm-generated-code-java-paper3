package CoT.llama31;
// Task38.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Task38 {

    public static void main(String[] args) {
        SpringApplication.run(Task38.class, args);
    }

    @PostMapping("/submit")
    public String handleSubmit(@RequestParam("userInput") String userInput) {
        return "You entered: " + userInput;
    }
}