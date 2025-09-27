package CoT.claude;

public class Task55 {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        
        // Check maximum length to prevent buffer overflow
        if (email.length() > 254) {
            return false;
        }

        // Check for @ symbol and proper position
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex == email.length() - 1) {
            return false;
        }

        // Split email into local and domain parts
        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // Validate local part
        if (localPart.length() > 64 || !localPart.matches("^[A-Za-z0-9._-]+$")) {
            return false;
        }

        // Validate domain part
        if (domainPart.length() > 255 || !domainPart.matches("^[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testEmails = {
            "test@example.com",           // valid
            "user.name@domain.co.uk",     // valid
            "invalid.email@",             // invalid
            "@nodomain.com",              // invalid
            "no.at.symbol"                // invalid
        };

        for (String email : testEmails) {
            System.out.println("Email: " + email + " is " + 
                (isValidEmail(email) ? "valid" : "invalid"));
        }
    }
}
