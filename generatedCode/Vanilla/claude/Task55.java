package Vanilla.claude;

public class Task55 {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty())
            return false;
            
        // Check for @ and . symbols
        int atIndex = email.indexOf('@');
        int lastDotIndex = email.lastIndexOf('.');
        
        if (atIndex < 1 || lastDotIndex < atIndex + 2 || lastDotIndex == email.length() - 1)
            return false;
            
        // Check local part and domain
        String localPart = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        
        // Check for valid characters
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.-_@";
        for (char c : email.toCharArray()) {
            if (allowedChars.indexOf(c) == -1)
                return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] emails = {
            "test@example.com",
            "invalid.email@com",
            "no@dot",
            "@nocontent.com",
            "test.email@domain.co.uk"
        };
        
        for (String email : emails) {
            System.out.println(email + " is " + (isValidEmail(email) ? "valid" : "invalid"));
        }
    }
}
