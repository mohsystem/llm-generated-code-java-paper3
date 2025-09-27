package ourMethod.gpt4o;
import java.util.Scanner;

public class Task116 {
    // Function to perform privileged operation of changing a user's password
    public static boolean changePassword(String username, String newPassword) {
        if (username == null || newPassword == null || username.isEmpty() || newPassword.isEmpty()) {
            return false;
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("sudo", "passwd", username);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            
            // Providing the new password to the passwd command
            process.getOutputStream().write((newPassword + "\n").getBytes());
            process.getOutputStream().write((newPassword + "\n").getBytes());
            process.getOutputStream().flush();
            process.getOutputStream().close();
            
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test cases
        System.out.println(changePassword("user1", "newPassword1")); // Test case 1
        System.out.println(changePassword("user2", "newPassword2")); // Test case 2
        System.out.println(changePassword("", "newPassword3")); // Test case 3
        System.out.println(changePassword("user4", "")); // Test case 4
        System.out.println(changePassword(null, null)); // Test case 5

        scanner.close();
    }
}