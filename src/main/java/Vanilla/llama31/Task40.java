package Vanilla.llama31;
// Task40.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Task40 {

    @GetMapping("/updateUser")
    public String updateUserForm(Model model) {
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("username") String username, 
                            @RequestParam("email") String email, 
                            @RequestParam("csrfToken") String csrfToken,
                            HttpServletRequest request, Model model) {
        // Validate CSRF token
        String expectedToken = (String) request.getSession().getAttribute("csrfToken");
        if (!csrfToken.equals(expectedToken)) {
            return "error";
        }

        // Update user settings
        System.out.println("Updating user settings for " + username + " with email " + email);
        return "success";
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        String csrfToken = java.util.UUID.randomUUID().toString();
        request.getSession().setAttribute("csrfToken", csrfToken);
        model.addAttribute("csrfToken", csrfToken);
        return "index";
    }

    public static void main(String[] args) {
        // Run the Spring Boot application
        org.springframework.boot.SpringApplication.run(Task40.class, args);
    }
}