package ourMethod.claude;

public class Task73 {
    public static boolean isValidAdminPassword(String password) {
        if(password == null || password.isEmpty()) {
            return false;
        }
        
        // Check minimum length
        if(password.length() < 12) {
            return false;
        }
        
        // Check for at least 1 uppercase letter
        if(!password.matches(".*[A-Z].*")) {
            return false;
        }
        
        // Check for at least 1 lowercase letter
        if(!password.matches(".*[a-z].*")) {
            return false;
        }
        
        // Check for at least 1 number
        if(!password.matches(".*[0-9].*")) {
            return false;
        }
        
        // Check for at least 1 special character
        if(!password.matches(".*[!@#$%^&*()_+\\-=\\\\[\\\\]{};':\"\\\\\\\\|,.<>\\\\/?].*")) {
            return false;
        }
        
        // Check for whitespace
        if(password.matches(".*\\\\s.*")) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "admin123", // too short
            "AdminPassword", // no special char or number
            "admin@password1", // no uppercase
            "ADMIN@PASSWORD1", // no lowercase
            "Admin@Password1", // valid password
        };
        
        for(String pwd : passwords) {
            System.out.println("Password: " + pwd + " is " + 
                (isValidAdminPassword(pwd) ? "valid" : "invalid"));
        }
    }
}
