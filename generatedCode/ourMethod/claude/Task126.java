package ourMethod.claude;

public class Task126 {
    public String redirectUser(String userInput) {
        // Input validation
        if (userInput == null || userInput.trim().isEmpty()) {
            return "/error.html"; // Default error page
        }
        
        // Sanitize input by removing special characters
        String sanitizedInput = userInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Map of valid redirects
        switch(sanitizedInput) {
            case "home":
                return "/home.html";
            case "about": 
                return "/about.html";
            case "contact":
                return "/contact.html";
            case "products":
                return "/products.html";
            default:
                return "/error.html";
        }
    }

    public static void main(String[] args) {
        Task126 task = new Task126();
        
        // Test cases
        System.out.println(task.redirectUser("home")); // Should print /home.html
        System.out.println(task.redirectUser("about")); // Should print /about.html 
        System.out.println(task.redirectUser("")); // Should print /error.html
        System.out.println(task.redirectUser("../admin")); // Should print /error.html
        System.out.println(task.redirectUser("<script>alert(1)</script>")); // Should print /error.html
    }
}
