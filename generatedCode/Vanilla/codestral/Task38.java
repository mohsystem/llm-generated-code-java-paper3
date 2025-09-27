package Vanilla.codestral;
//Java with Spring Framework

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class Task38 {

    @GetMapping("/")
    public String greetingForm(Model model) {
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@RequestParam(name="userInput", required=true) String userInput, Model model) {
        model.addAttribute("userInput", userInput);
        return "result";
    }
}