package ourMethod.codestral;
// Java example using Spring Framework

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/update")
public class UserSettingsController {

    @GetMapping
    public String getUpdateForm(Model model) {
        model.addAttribute("updateForm", new UpdateForm());
        return "update-form";
    }

    @PostMapping
    public String updateSettings(@ModelAttribute("updateForm") UpdateForm updateForm) {
        // Update user settings
        return "redirect:/success";
    }
}