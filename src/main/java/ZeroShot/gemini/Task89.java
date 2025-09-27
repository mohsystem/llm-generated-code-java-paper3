package ZeroShot.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class Task89 {
    public static boolean comparePasswords(String storedPassword, String enteredPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] storedPasswordHash = md.digest(storedPassword.getBytes());
            byte[] enteredPasswordHash = md.digest(enteredPassword.getBytes());

            return Arrays.equals(storedPasswordHash, enteredPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: SHA-256 algorithm not found.");
            return false;
        }
    }

    public static String readPasswordFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String password = scanner.nextLine();
            scanner.close();
            return password;
        } catch (FileNotFoundException e) {
            System.err.println("Error: Password file not found.");
            return null;
        }
    }

    public static void main(String[] args) {
        String storedPassword = readPasswordFromFile("password.txt");
        if (storedPassword == null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (comparePasswords(storedPassword, enteredPassword)) {
            System.out.println("Password verified.");
        } else {
            System.out.println("Incorrect password.");
        }
        scanner.close();



    }
}