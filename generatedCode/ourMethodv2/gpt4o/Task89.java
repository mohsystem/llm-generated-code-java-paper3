package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task89 {

    public static boolean verifyPassword(String filename, String inputPassword) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String storedPassword = br.readLine();
            if (storedPassword == null) {
                return false; // No password stored
            }
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
        System.out.println(verifyPassword("password.txt", "secret123")); // Example test case
        System.out.println(verifyPassword("password.txt", "wrongpass"));
        System.out.println(verifyPassword("password.txt", ""));
        System.out.println(verifyPassword("password.txt", "SECRET123"));
        System.out.println(verifyPassword("password.txt", "secret12"));
    }
}