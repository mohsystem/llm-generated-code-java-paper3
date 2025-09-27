package ourMethod.codestral;
// Java example using Spring Framework

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/update")
  class UserSettingsController {

    @GetMapping
    public String getUpdateForm(Model model) {
        //todo
//        model.addAttribute("updateForm", new UpdateForm());
        model.addAttribute("updateForm", null);
        return "update-form";
    }

    //todo
    @PostMapping
//    public String updateSettings(@ModelAttribute("updateForm") UpdateForm updateForm) {
    public String updateSettings() {
        // Update user settings
        return "redirect:/success";
    }
}