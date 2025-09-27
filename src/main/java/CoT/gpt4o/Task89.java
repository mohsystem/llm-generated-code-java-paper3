package CoT.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task89 {

    public static boolean comparePassword(String filePath, String inputPassword) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String storedPassword = br.readLine();
            if (storedPassword == null || storedPassword.length() != inputPassword.length()) {
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
        System.out.println(comparePassword("password.txt", "userInput1")); // Example output
        System.out.println(comparePassword("password.txt", "userInput2")); // Example output
        System.out.println(comparePassword("password.txt", "userInput3")); // Example output
        System.out.println(comparePassword("password.txt", "userInput4")); // Example output
        System.out.println(comparePassword("password.txt", "userInput5")); // Example output
    }
}