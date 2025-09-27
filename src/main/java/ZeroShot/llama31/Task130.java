package ZeroShot.llama31;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.filter.CorsWebFilter;

@SpringBootApplication
public class Task130 {

    public static void main(String[] args) {
        SpringApplication.run(Task130.class, args);

        // Test cases
        testCORS("http://www.example.com", "GET", "api/test");
        testCORS("http://www.example.com", "POST", "api/test");
        testCORS("http://otherdomain.com", "GET", "api/test"); // Should be blocked
        testCORS("http://www.example.com", "PUT", "api/test");
        testCORS("http://www.example.com", "DELETE", "api/test");
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("http://www.example.com");
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        //todo incompatible types: String cannot be converted to RequestMethod
//        return new CorsWebFilter(source);
        return new CorsWebFilter((CorsConfigurationSource) source);
    }

    @RestController
    public static class MyController {
        //todo incompatible types: String cannot be converted to RequestMethod
//        @CrossOrigin(origins = "http://www.example.com", allowedHeaders = "*", methods = "*")
        @CrossOrigin(origins = "http://www.example.com", allowedHeaders = "*", methods = RequestMethod.GET)
        @GetMapping("/api/test")
        public String test() {
            return "Hello, World!";
        }
    }

    public static void testCORS(String origin, String method, String path) {
        // Simulate a request and check the response headers
        System.out.println("Testing CORS for " + origin + " with method " + method + " on path " + path);
        // Implement your test logic here, possibly using a HTTP client library.
    }
}