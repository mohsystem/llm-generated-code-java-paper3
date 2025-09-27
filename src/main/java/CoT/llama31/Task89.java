package CoT.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task89 {
    public static boolean comparePasswords(String storedPassword, String userInput) {
        if (storedPassword.length() != userInput.length()) {
            return false;
        }
        for (int i = 0; i < storedPassword.length(); i++) {
            if (storedPassword.charAt(i) != userInput.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String readPasswordFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            return scanner.nextLine().trim();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }
    }

    public static void main(String[] args) {
        String filename = "password.txt";
        String storedPassword = readPasswordFromFile(filename);
        if (storedPassword != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your password: ");
            String userInput = scanner.nextLine();
            if (comparePasswords(storedPassword, userInput)) {
                System.out.println("Passwords match.");
            } else {
                System.out.println("Passwords do not match.");
            }
        }

        // Test cases
        System.out.println(comparePasswords("password123", "password123")); // true
        System.out.println(comparePasswords("password123", "wrongpassword")); // false
        System.out.println(comparePasswords("password123", "password12")); // false
        System.out.println(comparePasswords("password123", "password1234")); // false
        System.out.println(comparePasswords("password123", "Password123")); // false
    }
}