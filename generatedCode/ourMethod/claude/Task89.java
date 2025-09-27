package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Arrays;

public class Task89 {
    // Compare passwords securely using constant time comparison
    private static boolean comparePasswords(char[] storedPass, char[] inputPass) {
        if (storedPass.length != inputPass.length) {
            return false;
        }
        
        boolean result = true;
        for (int i = 0; i < storedPass.length; i++) {
            // Use & instead of && to prevent timing attacks
            result &= (storedPass[i] == inputPass[i]);
        }
        return result;
    }
    
    public static boolean verifyPassword(String filename, char[] inputPassword) {
        try {
            // Read stored password securely
            String storedPass = Files.readString(Path.of(filename)).trim();
            char[] storedChars = storedPass.toCharArray();
            
            boolean result = comparePasswords(storedChars, inputPassword);
            
            // Clean up sensitive data
            Arrays.fill(storedChars, '\\0');
            
            return result;
        } catch (IOException e) {
            return false;
        } finally {
            // Clean up input password
            Arrays.fill(inputPassword, '\\0');
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPasswords = {
            "correctpass",
            "wrongpass",
            "short",
            "verylongpassword",
            ""
        };
        
        try {
            // Create test file with stored password
            Files.writeString(Path.of("password.txt"), "correctpass");
            
            for (String pass : testPasswords) {
                char[] inputPass = pass.toCharArray();
                boolean result = verifyPassword("password.txt", inputPass);
                System.out.println("Password '" + pass + "': " + result);
            }
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }
}
