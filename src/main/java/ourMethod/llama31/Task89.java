package ourMethod.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task89 {
    public static boolean comparePasswords(String storedPassword, String userInput) {
        if (storedPassword == null || userInput == null) {
            return false;
        }
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
            System.out.println("File not found: " + e.getMessage());
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
                System.out.println("Access granted");
            } else {
                System.out.println("Access denied");
            }
        }
    }
}