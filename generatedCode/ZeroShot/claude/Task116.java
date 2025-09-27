package ZeroShot.claude;

import java.io.*;
import java.security.*;

public class Task116 {
    private static final String ADMIN_USER = "admin";
    private static boolean isPrivileged = false;
    
    public static boolean changeUserPassword(String username, String newPassword) {
        if (!isPrivileged) {
            System.err.println("Error: Insufficient privileges");
            return false;
        }
        
        try {
            // Simulate changing password securely
            if (username == null || username.trim().isEmpty() || 
                newPassword == null || newPassword.trim().isEmpty()) {
                return false;
            }

            // Perform privileged operation
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"chpasswd"};
            Process proc = rt.exec(commands);
            
            // Write username:password to process
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
            writer.write(username + ":" + newPassword);
            writer.close();

            // Drop privileges immediately after operation
            dropPrivileges();
            
            int exitVal = proc.waitFor();
            return exitVal == 0;
            
        } catch (Exception e) {
            System.err.println("Error changing password: " + e.getMessage());
            dropPrivileges();
            return false;
        }
    }
    
    private static void dropPrivileges() {
        isPrivileged = false;
        // Reset to non-privileged user
        try {
            String username = System.getProperty("user.name");
            if (!username.equals(ADMIN_USER)) {
                Runtime.getRuntime().exec("su " + username);
            }
        } catch (Exception e) {
            System.err.println("Error dropping privileges: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        isPrivileged = true; // Simulating privileged access granted
        
        // Test 1: Valid change
        System.out.println(changeUserPassword("testuser1", "newpass123")); 
        
        // Test 2: Empty username
        System.out.println(changeUserPassword("", "newpass123"));
        
        // Test 3: Empty password
        System.out.println(changeUserPassword("testuser2", ""));
        
        // Test 4: Null values
        System.out.println(changeUserPassword(null, null));
        
        // Test 5: Without privileges
        isPrivileged = false;
        System.out.println(changeUserPassword("testuser3", "newpass123"));
    }
}
