package CoT.gemini;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class Task89 {
    private static final String STORED_PASSWORD_FILE = "stored_password.txt";
    private static final String SALT = "a_random_salt"; // Use a strong, randomly generated salt in a real application

    public static boolean comparePasswords(String enteredPassword) throws IOException, NoSuchAlgorithmException {
        String storedHashedPassword = new String(Files.readAllBytes(Paths.get(STORED_PASSWORD_FILE))).trim();

        String enteredHashedPassword = hashPassword(enteredPassword);
        return storedHashedPassword.equals(enteredHashedPassword);
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        md.update(password.getBytes());
        byte[] hash = md.digest();
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // Test cases - In real application, do not store passwords in plaintext
        String testPassword = "password123";
        Files.write(Paths.get(STORED_PASSWORD_FILE), hashPassword(testPassword).getBytes());

        Console console = System.console();
        if (console == null) {
            System.err.println("No console available.");
            System.exit(1);
        }

        char[] enteredPasswordChars = console.readPassword("Enter your password: ");
        String enteredPassword = new String(enteredPasswordChars);
        Arrays.fill(enteredPasswordChars, ' '); // Clear password from memory


        for (int i = 0; i < 5; i++) {
            if (comparePasswords(enteredPassword)) {
                System.out.println("Test case " + (i + 1) + ": Password matches.");
            } else {
                System.out.println("Test case " + (i + 1) + ": Password does not match.");
            }
        }
    }
}