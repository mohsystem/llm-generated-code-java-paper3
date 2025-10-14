package ourMethod.openai;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task89 {
    public static boolean comparePasswords(String filePath, String inputPassword) {
        try {
            String storedPassword = new String(Files.readAllBytes(Paths.get(filePath))).trim();
            if (storedPassword.length() != inputPassword.length()) {
                return false;
            }
            for (int i = 0; i < storedPassword.length(); i++) {
                if (storedPassword.charAt(i) != inputPassword.charAt(i)) {
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
        System.out.println(comparePasswords("password.txt", "password1"));
        System.out.println(comparePasswords("password.txt", "password2"));
        System.out.println(comparePasswords("password.txt", "password3"));
        System.out.println(comparePasswords("password.txt", "password4"));
        System.out.println(comparePasswords("password.txt", "password5"));
    }
}