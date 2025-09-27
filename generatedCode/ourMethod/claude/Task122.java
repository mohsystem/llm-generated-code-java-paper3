package ourMethod.claude;

import org.mindrot.jbcrypt.BCrypt;
import java.util.*;
import java.util.regex.Pattern;

public class Task122 {
    private static Map<String, String> userDatabase = new HashMap<>();
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$");
    
    public static boolean signUp(String username, String password) {
        if (username == null || password == null || username.trim().isEmpty()) {
            return false;
        }
        
        // Check if user already exists
        if (userDatabase.containsKey(username)) {
            return false;
        }
        
        // Validate password strength
        if (!isPasswordStrong(password)) {
            return false;
        }
        
        // Hash password with BCrypt (includes salt automatically)
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        
        // Store username and hashed password
        userDatabase.put(username, hashedPassword);
        return true;
    }
    
    private static boolean isPasswordStrong(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(signUp("user1", "Secure@Pass123")); // Should return true
        System.out.println(signUp("user2", "weak")); // Should return false (too short)
        System.out.println(signUp("user1", "Another@Pass123")); // Should return false (user exists)
        System.out.println(signUp("user3", "NoSpecialChar123")); // Should return false (no special char)
        System.out.println(signUp("user4", "Secure@Pass123!")); // Should return true
    }
}
