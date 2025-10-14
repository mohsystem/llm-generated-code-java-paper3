package ZeroShot.openai;
import java.nio.file.*;
import java.io.IOException;

public class Task89 {
    public static boolean comparePasswords(String storedPasswordFile, String enteredPassword) {
        try {
            String storedPassword = Files.readString(Paths.get(storedPasswordFile)).trim();
            if (storedPassword.length() != enteredPassword.length()) return false;
            for (int i = 0; i < storedPassword.length(); i++) {
                if (storedPassword.charAt(i) != enteredPassword.charAt(i)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(comparePasswords("password.txt", "password1")); // false
        System.out.println(comparePasswords("password.txt", "password123")); // false
        System.out.println(comparePasswords("password.txt", "password")); // true
        System.out.println(comparePasswords("password.txt", "Password")); // false
        System.out.println(comparePasswords("password.txt", "passw0rd")); // false
    }
}