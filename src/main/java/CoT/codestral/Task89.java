package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task89 {
    public static boolean comparePasswords(String inputPassword) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("password.txt"));
        String storedPassword = reader.readLine();
        reader.close();

        if (inputPassword.length() != storedPassword.length()) {
            return false;
        }

        for (int i = 0; i < inputPassword.length(); i++) {
            if (inputPassword.charAt(i) != storedPassword.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String inputPassword = scanner.nextLine();
        scanner.close();

        if (comparePasswords(inputPassword)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }
    }
}