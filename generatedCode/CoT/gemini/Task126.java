package CoT.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task126 {

    public static String redirect(String input) {
        // Use a Map to store the mappings between user input and URLs.
        Map<String, String> redirectMap = new HashMap<>();
        redirectMap.put("home", "/home");
        redirectMap.put("about", "/about");
        redirectMap.put("contact", "/contact");
        redirectMap.put("products", "/products");


        // Retrieve the corresponding URL from the map.
        String url = redirectMap.getOrDefault(input.toLowerCase(), "/error"); // Default to error page if input is invalid

        return url;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your choice (home, about, contact, products):");
        String input = scanner.nextLine();


        String redirectedUrl = redirect(input);
        System.out.println("Redirecting to: " + redirectedUrl);


        // Test cases
        System.out.println(redirect("home")); // Expected: /home
        System.out.println(redirect("About")); // Expected: /about
        System.out.println(redirect("invalid")); // Expected: /error
        System.out.println(redirect("PRODUCTS")); // Expected: /products
        System.out.println(redirect("contact")); // Expected: /contact
    }
}