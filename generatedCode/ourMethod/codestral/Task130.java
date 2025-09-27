package ourMethod.codestral;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MyController {
    @CrossOrigin(origins = "http://example.com")
    @RequestMapping("/api")
    public String myApi() {
        return "API response";
    }
}