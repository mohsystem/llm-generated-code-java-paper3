package ourMethod.gemini;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task89 {

    public static boolean comparePasswords(String storedPassword, String enteredPassword) {
        char[] storedPasswordChars = storedPassword.toCharArray();
        char[] enteredPasswordChars = enteredPassword.toCharArray();

        if (storedPasswordChars.length != enteredPasswordChars.length) {
            return false;
        }

        for (int i = 0; i < storedPasswordChars.length; i++) {
            if (storedPasswordChars[i] != enteredPasswordChars[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // Test cases
        System.out.println("Test case 1: " + comparePasswords("password123", "password123")); // Expected: true
        System.out.println("Test case 2: " + comparePasswords("password123", "Password123")); // Expected: false
        System.out.println("Test case 3: " + comparePasswords("password123", "pass")); // Expected: false
        System.out.println("Test case 4: " + comparePasswords("", "")); // Expected: true
        System.out.println("Test case 5: " + comparePasswords("12345", "123456")); // Expected: false


        // Example usage with file reading (replace "password_file.txt" with your file)
        File passwordFile = new File("password_file.txt");
        Scanner scanner = new Scanner(passwordFile);
        String storedPasswordFromFile = scanner.nextLine();
        scanner.close();

        Console console = System.console();
        if (console == null) {
            System.out.println("Console not available");
            return;
        }
        char[] enteredPasswordChars = console.readPassword("Enter your password: ");
        String enteredPassword = new String(enteredPasswordChars);

        Arrays.fill(enteredPasswordChars, ' '); // Clear password from memory

        if (comparePasswords(storedPasswordFromFile, enteredPassword)) {
            System.out.println("Password verified.");
        } else {
            System.out.println("Incorrect password.");
        }
    }
}