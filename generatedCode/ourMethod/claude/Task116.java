package ourMethod.claude;

import java.io.Console;
import java.io.IOException;
import java.util.regex.Pattern;

public class Task116 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{3,20}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9@#$%^&+=]{8,20}$");
    
    public static boolean changePassword(String username, String newPassword) {
        if (!validateInput(username, newPassword)) {
            return false;
        }
        
        try {
            // Verify current privileges
            if (!isRoot()) {
                System.err.println("Error: Root privileges required");
                return false;
            }
            
            // Change password using system command
            String[] cmd = {"/usr/bin/passwd", username};
            Process process = Runtime.getRuntime().exec(cmd);
            
            // Write new password to process
            process.getOutputStream().write((newPassword + "\n" + newPassword + "\n").getBytes());
            process.getOutputStream().flush();
            process.getOutputStream().close();
            
            // Wait for completion
            int result = process.waitFor();
            
            // Drop privileges after operation
            dropPrivileges();
            
            return result == 0;
        } catch (IOException | InterruptedException e) {
            System.err.println("Error changing password: " + e.getMessage());
            return false;
        } finally {
            // Ensure privileges are dropped even if exception occurs
            dropPrivileges();
        }
    }
    
    private static boolean validateInput(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return USERNAME_PATTERN.matcher(username).matches() && 
               PASSWORD_PATTERN.matcher(password).matches();
    }
    
    private static boolean isRoot() {
        return System.getProperty("user.name").equals("root");
    }
    
    private static void dropPrivileges() {
        try {
            String[] cmd = {"su", "nobody"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error dropping privileges: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"user1", "Password123"},
            {"admin", "Admin@123"},
            {"test_user", "Test#1234"},
            {"root", "Root$1234"},
            {"system", "System@123"}
        };

        for (String[] test : testCases) {
            System.out.println("\\nTesting with username: " + test[0] + ", password: " + test[1]);
            boolean result = changePassword(test[0], test[1]);
            System.out.println("Password change " + (result ? "successful" : "failed"));
        }
    }
}
