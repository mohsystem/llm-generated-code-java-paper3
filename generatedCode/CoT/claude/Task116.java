package CoT.claude;

import java.io.*;
import java.util.*;

public class Task116 {
    private static boolean isPrivilegedUser() {
        // Check if current user has root/admin privileges
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            try {
                Process p = Runtime.getRuntime().exec("net session");
                int exitCode = p.waitFor();
                return (exitCode == 0);
            } catch (Exception e) {
                return false;
            }
        } else {
            return (System.getProperty("user.name").equals("root"));
        }
    }
    
    private static boolean changeUserPassword(String username, String newPassword) {
        if (!isPrivilegedUser()) {
            System.out.println("Error: Requires privileged access");
            return false;
        }
        
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String[] command;
            if (os.contains("windows")) {
                command = new String[]{"net", "user", username, newPassword};
            } else {
                command = new String[]{"passwd", username};
            }
            
            Process process = Runtime.getRuntime().exec(command);
            if (os.contains("linux") || os.contains("unix")) {
                // Send password via stdin for Unix-like systems
                try (OutputStream out = process.getOutputStream()) {
                    out.write((newPassword + "\n" + newPassword + "\n").getBytes());
                    out.flush();
                }
            }
            
            int result = process.waitFor();
            return result == 0;
            
        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
            return false;
        } finally {
            // Drop privileges by switching to normal user context
            try {
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    Runtime.getRuntime().exec("runas /user:standard_user cmd.exe");
                } else {
                    Runtime.getRuntime().exec("su - unprivileged_user");
                }
            } catch (IOException e) {
                System.out.println("Error dropping privileges: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"user1", "newpass123"},
            {"testuser", "securepass456"},
            {"admin", "adminpass789"},
            {"guest", "guestpass321"},
            {"system", "syspass987"}
        };
        
        for (String[] test : testCases) {
            System.out.println("Attempting to change password for user: " + test[0]);
            boolean success = changeUserPassword(test[0], test[1]);
            System.out.println("Password change " + (success ? "successful" : "failed"));
            System.out.println("------------------------");
        }
    }
}
