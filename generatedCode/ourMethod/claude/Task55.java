package ourMethod.claude;

public class Task55 {
    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        
        // Check maximum length to prevent buffer overflow
        if (email.length() > 254) {
            return false; 
        }
        
        // Basic pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        // Additional validation checks
        if (!email.matches(emailRegex)) {
            return false;
        }
        
        // Check for @ symbol and its position
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex == email.length() - 1) {
            return false;
        }
        
        // Validate local part and domain lengths
        String localPart = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        
        if (localPart.length() > 64 || domain.length() > 255) {
            return false;
        }
        
        // Check for consecutive dots
        if (email.contains("..")) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testEmails = {
            "test@example.com",            // valid
            "user.name@domain.com",        // valid
            "invalid.email@",              // invalid
            "@invalid.com",               // invalid
            "test..email@domain.com"      // invalid
        };
        
        for (String email : testEmails) {
            System.out.println("Email: " + email + " is " + 
                (validateEmail(email) ? "valid" : "invalid"));
        }
    }
}
