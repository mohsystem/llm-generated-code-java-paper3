package ourMethod.llama31;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class Task38 {

    public static void main(String[] args) {
        SpringApplication.run(Task38.class, args);
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("username") String username, @RequestParam("message") String message, Model model) {
        // Basic validation to prevent common attacks like XSS
        if (username == null || username.isEmpty() || message == null || message.isEmpty()) {
            return "error";
        }
        // Sanitize input to prevent XSS
        username = username.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        message = message.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        
        model.addAttribute("username", username);
        model.addAttribute("message", message);
        return "result";
    }
}