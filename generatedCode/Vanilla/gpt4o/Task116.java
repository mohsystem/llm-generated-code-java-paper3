package Vanilla.openai;
import java.io.IOException;
import java.util.Scanner;

public class Task116 {
    
    public static void changePassword(String username, String newPassword) throws IOException {
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            throw new UnsupportedOperationException("This operation is not supported on non-Windows systems.");
        }
        String command = "net user " + username + " " + newPassword;
        Process process = Runtime.getRuntime().exec(command);
        try {
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Failed to change password.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // This example will run only on Windows
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter new password: ");
            String newPassword = scanner.nextLine();
            try {
                changePassword(username, newPassword);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}