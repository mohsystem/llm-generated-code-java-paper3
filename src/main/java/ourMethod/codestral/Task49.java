package ourMethod.codestral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
  class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/add_user")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        jdbcTemplate.update("INSERT INTO users (username, email) VALUES (?, ?)",
                user.getUsername(), user.getEmail());
        return "{\"status\": \"success\"}";
    }


    class User {
        private String name;
        private String email;
        private String password;
        private String username;

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }
    }
}
