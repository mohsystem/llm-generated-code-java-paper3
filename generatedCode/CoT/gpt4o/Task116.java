package CoT.openai;
import java.io.Console;

public class Task116 {

    public static void changeUserPassword(String username, String newPassword) {
        try {
            // Using sudo command to change the password, requires sudo privileges
            ProcessBuilder processBuilder = new ProcessBuilder("sudo", "passwd", username);
            Process process = processBuilder.start();

            // Provide new password to the passwd command
            Console console = System.console();
            if (console != null) {
                console.printf("%s\n", newPassword);
                console.printf("%s\n", newPassword);
            }

            // Wait for the process to complete
            process.waitFor();

            // Drop privileges: this is usually platform-specific and requires system admin configuration
            System.setProperty("user.name", "noprivuser");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test cases
        changeUserPassword("user1", "newPassword1");
        changeUserPassword("user2", "newPassword2");
        changeUserPassword("user3", "newPassword3");
        changeUserPassword("user4", "newPassword4");
        changeUserPassword("user5", "newPassword5");
    }
}