package ZeroShot.claude;

public class Task120 {
    public static String displayUserInput(String userInput) {
        if (userInput == null) {
            return "";
        }
        // Sanitize input by encoding HTML special characters
        String sanitized = userInput
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\\"", "&quot;")
            .replace("'", "&#x27;")
            .replace("/", "&#x2F;");
            
        return "<p>" + sanitized + "</p>";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(displayUserInput("Hello World"));
        System.out.println(displayUserInput("<script>alert('XSS')</script>"));
        System.out.println(displayUserInput("Text with & < > \\" ' / symbols"));
        System.out.println(displayUserInput(null));
        System.out.println(displayUserInput("Regular text 123"));
    }
}
