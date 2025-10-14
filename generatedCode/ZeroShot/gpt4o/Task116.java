package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task116 {
    public static void main(String[] args) {
        changeUserPassword("user1", "newPassword1");
        changeUserPassword("user2", "newPassword2");
        changeUserPassword("user3", "newPassword3");
        changeUserPassword("user4", "newPassword4");
        changeUserPassword("user5", "newPassword5");
    }

    public static void changeUserPassword(String username, String newPassword) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        try {
            // Perform privileged operation
            processBuilder.command("sudo", "passwd", username);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Drop privileges (simulate by ending the process)
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Password changed successfully for user: " + username);
            } else {
                System.out.println("Failed to change password for user: " + username);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}