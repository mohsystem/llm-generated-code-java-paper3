package CoT.claude;

// Java (using Spring Boot)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@SpringBootApplication
public class Task38 {
    public static void main(String[] args) {
        SpringApplication.run(Task38.class, args);
    }
}

@Controller
class FormController {
    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String handleSubmission(@RequestParam String userInput, Model model) {
        // Sanitize input to prevent XSS
        String sanitizedInput = HtmlUtils.htmlEscape(userInput);
        model.addAttribute("userInput", sanitizedInput);
        return "result";
    }
}

// form.html
/*
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Input Form</title>
</head>
<body>
    <form action="/submit" method="post">
        <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
        <input type="text" name="userInput" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
*/

// result.html
/*
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Result</title>
</head>
<body>
    <h2>Your input:</h2>
    <p th:text="${userInput}"></p>
</body>
</html>
*/
