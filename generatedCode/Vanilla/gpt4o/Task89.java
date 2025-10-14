package Vanilla.openai;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task89 {
    public static boolean comparePasswords(String filePath, String userInput) {
        String filePassword = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            filePassword = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
        if (filePassword == null || userInput.length() != filePassword.length()) {
            return false;
        }
        
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) != filePassword.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(comparePasswords("password.txt", "password123")); // false
        System.out.println(comparePasswords("password.txt", "password")); // true
        System.out.println(comparePasswords("password.txt", "passw0rd")); // false
        System.out.println(comparePasswords("password.txt", "password!")); // false
        System.out.println(comparePasswords("password.txt", "")); // false
    }
}