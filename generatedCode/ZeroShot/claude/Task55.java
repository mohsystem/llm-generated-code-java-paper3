package ZeroShot.claude;

import java.util.regex.Pattern;

public class Task55 {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        
        // RFC 5322 compliant email regex pattern
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] emails = {
            "test@example.com",
            "user.name@domain.co.in", 
            "invalid.email@",
            "@invalid.com",
            "test@.com"
        };
        
        for(String email : emails) {
            System.out.println(email + " is " + (isValidEmail(email) ? "valid" : "invalid"));
        }
    }
}
