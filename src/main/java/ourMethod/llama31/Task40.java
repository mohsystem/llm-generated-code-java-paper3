package ourMethod.llama31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
  class UserController {

    @GetMapping("/updateUser")
    public String getUserUpdateForm(Model model, HttpSession session) {
        // Generate CSRF token
        String csrfToken = java.util.UUID.randomUUID().toString();
        session.setAttribute("csrfToken", csrfToken);
        model.addAttribute("csrfToken", csrfToken);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("csrfToken") String csrfToken, 
                            @RequestParam("username") String username, 
                            @RequestParam("email") String email, 
                            HttpSession session) {
        // Validate CSRF token
        String expectedCsrfToken = (String) session.getAttribute("csrfToken");
        if (!csrfToken.equals(expectedCsrfToken)) {
            return "error";
        }

        // Update user settings
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//todo not defined
        //        userDetails.setUsername(username);
//        userDetails.setEmail(email);

        return "updateSuccess";
    }
}