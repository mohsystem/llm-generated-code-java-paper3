package CoT.claude;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class Task89 {
    private static String readPasswordFromFile(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename))).trim();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    private static boolean comparePasswords(String storedPass, String userPass) {
        if (storedPass == null || userPass == null) {
            return false;
        }
        
        if (storedPass.length() != userPass.length()) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < storedPass.length(); i++) {
            if (storedPass.charAt(i) != userPass.charAt(i)) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "password123",
            "wrongpass",
            "correctpass",
            "test1234",
            "securepass"
        };

        // Create test file with stored password
        try {
            Files.write(Paths.get("password.txt"), "correctpass".getBytes());
        } catch (IOException e) {
            System.out.println("Error creating test file");
            return;
        }

        for (String input : testInputs) {
            String storedPassword = readPasswordFromFile("password.txt");
            boolean match = comparePasswords(storedPassword, input);
            System.out.println("Test password: " + input + " - Match: " + match);
        }
    }
}
