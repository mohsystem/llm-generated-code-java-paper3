package Vanilla.claude;

import java.io.*;
import java.util.Scanner;

public class Task89 {
    public static boolean comparePassword(String storedPass, String enteredPass) {
        if (storedPass.length() != enteredPass.length()) {
            return false;
        }
        
        for (int i = 0; i < storedPass.length(); i++) {
            if (storedPass.charAt(i) != enteredPass.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] storedPasswords = {
            "password123",
            "abc123",
            "test@123",
            "",
            "Pass Word"
        };
        
        String[] enteredPasswords = {
            "password123", // true
            "abc124", // false
            "test@12", // false
            "", // true
            "Pass word" // false
        };
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Test Case " + (i+1) + ": " + 
                comparePassword(storedPasswords[i], enteredPasswords[i]));
        }
    }
}
