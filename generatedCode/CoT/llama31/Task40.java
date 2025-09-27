package CoT.llama31;
// Task40.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Task40 {

    @Autowired
    private UserService userService;

    @GetMapping("/updateUser")
    public String getUserForm(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("user", userDetails);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@AuthenticationPrincipal UserDetails userDetails,
                            @RequestParam("username") String username,
                            @RequestParam("email") String email,
                            HttpServletRequest request) {
        String token = request.getParameter("_csrf");
        if (!request.getSession().getAttribute("_csrf").equals(token)) {
            throw new RuntimeException("CSRF token mismatch");
        }
        userService.updateUser(userDetails.getUsername(), username, email);
        return "redirect:/updateUser";
    }
}