package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task89 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password: ");
        String userInput = scanner.nextLine();
        scanner.close();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("password.txt"));
            String storedPassword = reader.readLine();
            reader.close();

            if (isPasswordMatch(storedPassword, userInput)) {
                System.out.println("Password is correct.");
            } else {
                System.out.println("Password is incorrect.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the password file.");
        }
    }

    private static boolean isPasswordMatch(String storedPassword, String userInput) {
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
}