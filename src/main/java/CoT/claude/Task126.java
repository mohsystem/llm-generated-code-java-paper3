package CoT.claude;

public class Task126 {
    public static String getRedirectPage(String userInput) {
        // Input validation
        if (userInput == null || userInput.trim().isEmpty()) {
            return "error.html";
        }
        
        // Sanitize input by converting to lowercase and removing whitespace
        String sanitizedInput = userInput.toLowerCase().trim();
        
        // Use switch case for redirection logic
        switch(sanitizedInput) {
            case "home":
                return "home.html";
            case "about":
                return "about.html"; 
            case "contact":
                return "contact.html";
            case "products":
                return "products.html";
            case "services":
                return "services.html";
            default:
                return "error.html";
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(getRedirectPage("home"));     // Should print home.html
        System.out.println(getRedirectPage("ABOUT"));    // Should print about.html
        System.out.println(getRedirectPage("contact  ")); // Should print contact.html
        System.out.println(getRedirectPage(""));         // Should print error.html
        System.out.println(getRedirectPage("invalid"));  // Should print error.html
    }
}
