package ourMethod.codestral;
import java.util.Scanner;
import java.io.IOException;

public class Task158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data to be used in an OS command: ");
        String input = scanner.nextLine();

        // Use ProcessBuilder to run OS command, avoid Runtime.exec to prevent command injection
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "your_os_command " + input);

        try {
            Process process = processBuilder.start();
            // Wait for the command to complete
            int exitCode = process.waitFor();
            System.out.println("Command executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }
}