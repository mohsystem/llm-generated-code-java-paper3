package ZeroShot.claude;

import java.io.*;
import java.util.Arrays;
import java.nio.file.*;

public class Task89 {
    public static boolean comparePassword(String storedPass, String inputPass) {
        if (storedPass == null || inputPass == null) {
            return false;
        }
        
        if (storedPass.length() != inputPass.length()) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < storedPass.length(); i++) {
            result &= (storedPass.charAt(i) == inputPass.charAt(i));
        }
        return result;
    }
    
    public static void main(String[] args) {
        try {
            // Test cases
            String storedPassword = new String(Files.readAllBytes(Paths.get("password.txt")));
            
            // Test case 1: Correct password
            System.out.println(comparePassword(storedPassword, storedPassword)); // true
            
            // Test case 2: Wrong password
            System.out.println(comparePassword(storedPassword, "wrongpass")); // false
            
            // Test case 3: Empty password
            System.out.println(comparePassword(storedPassword, "")); // false
            
            // Test case 4: Null password
            System.out.println(comparePassword(storedPassword, null)); // false
            
            // Test case 5: Same length but different characters
            System.out.println(comparePassword(storedPassword, "X".repeat(storedPassword.length()))); // false
            
        } catch (IOException e) {
            System.err.println("Error reading password file: " + e.getMessage());
        }
    }
}
