package ourMethod.claude;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task109 {
    // Validate email address format
    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    // Validate phone number format
    public static boolean validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        String phoneRegex = "^\\\\d{10}$";
        return Pattern.compile(phoneRegex).matcher(phone).matches();
    }

    // Validate username format
    public static boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        String usernameRegex = "^[A-Za-z0-9_]{3,20}$";
        return Pattern.compile(usernameRegex).matcher(username).matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] emails = {
            "test@example.com",
            "invalid.email@",
            "test.email@domain.com",
            "@invalid.com",
            "test@.com"
        };
        
        String[] phones = {
            "1234567890",
            "123456",
            "12345678901",
            "abcdefghij",
            "123-456-7890"
        };
        
        String[] usernames = {
            "user123",
            "ab",
            "validUsername_123",
            "too_long_username_123456",
            "invalid@username"
        };

        // Test email validation
        System.out.println("Email Validation:");
        for (String email : emails) {
            System.out.println(email + " : " + validateEmail(email));
        }

        // Test phone validation  
        System.out.println("\\nPhone Validation:");
        for (String phone : phones) {
            System.out.println(phone + " : " + validatePhone(phone));
        }

        // Test username validation
        System.out.println("\\nUsername Validation:");
        for (String username : usernames) {
            System.out.println(username + " : " + validateUsername(username));
        }
    }
}
