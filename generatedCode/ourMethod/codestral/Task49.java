package ourMethod.codestral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/add_user")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        jdbcTemplate.update("INSERT INTO users (username, email) VALUES (?, ?)",
                user.getUsername(), user.getEmail());
        return "{\"status\": \"success\"}";
    }
}