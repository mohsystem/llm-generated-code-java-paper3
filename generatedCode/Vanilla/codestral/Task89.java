package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task89 {
    public static boolean comparePassword(String filePath, String inputPassword) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String storedPassword = reader.readLine();
        reader.close();

        if (storedPassword.length() != inputPassword.length()) {
            return false;
        }

        for (int i = 0; i < storedPassword.length(); i++) {
            if (storedPassword.charAt(i) != inputPassword.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "password.txt";
        String[] testCases = {"password123", "wrongPassword", "p@ssw0rd", "pass123", "pass"};

        for (String testCase : testCases) {
            System.out.println("Input Password: " + testCase);
            System.out.println("Match: " + comparePassword(filePath, testCase));
            System.out.println();
        }
    }
}