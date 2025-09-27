package Vanilla.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Task89 {
    public static boolean comparePasswords(String storedPassword, String enteredPassword) {
        if (storedPassword.length() != enteredPassword.length()) {
            return false;
        }
        for (int i = 0; i < storedPassword.length(); i++) {
            if (storedPassword.charAt(i) != enteredPassword.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("password.txt");
        Scanner scanner = new Scanner(file);
        String storedPassword = scanner.nextLine();
        scanner.close();

        System.out.println(comparePasswords(storedPassword, "password123"));
        System.out.println(comparePasswords(storedPassword, "passwor123"));
        System.out.println(comparePasswords(storedPassword, "password1234"));
        System.out.println(comparePasswords(storedPassword, "pa55word123"));
        System.out.println(comparePasswords(storedPassword, storedPassword));
    }
}