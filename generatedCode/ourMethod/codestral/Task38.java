package ourMethod.codestral;
@Controller
public class Task38 {

    @GetMapping("/input")
    public String inputForm(Model model) {
        return "input"; // This is the name of the Thymeleaf template that contains the form
    }

    @PostMapping("/output")
    public String outputForm(@RequestParam String userInput, Model model) {
        model.addAttribute("userInput", userInput);
        return "output"; // This is the name of the Thymeleaf template that displays the user input
    }

    public static void main(String[] args) {
        SpringApplication.run(Task38.class, args);
    }
}