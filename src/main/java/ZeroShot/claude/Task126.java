package ZeroShot.claude;

public class Task126 {
    public static String redirectPage(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return "error.html"; // Default error page
        }
        
        // Sanitize input by removing special characters
        userInput = userInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        switch(userInput) {
            case "home":
                return "home.html";
            case "about":
                return "about.html"; 
            case "contact":
                return "contact.html";
            case "products":
                return "products.html";
            default:
                return "error.html";
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(redirectPage("home")); // home.html
        System.out.println(redirectPage("about")); // about.html
        System.out.println(redirectPage("<script>alert(1)</script>")); // error.html 
        System.out.println(redirectPage("")); // error.html
        System.out.println(redirectPage("products")); // products.html
    }
}
