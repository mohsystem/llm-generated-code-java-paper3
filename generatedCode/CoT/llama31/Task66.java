package CoT.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {
    public static void main(String[] args) throws IOException {
        // Test cases
        String[] commands = {"ls -l", "echo Hello World", "invalid command", "rm -rf /"};

        for (String command : commands) {
            if (validateCommand(command)) {
                executeCommand(command);
            } else {
                System.out.println("Invalid command: " + command);
            }
        }
    }

    public static boolean validateCommand(String command) {
        // Basic validation, should be more robust in real scenarios
        return !command.contains("rm") && !command.contains("rm -rf");
    }

    public static void executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = output.readLine()) != null) {
            System.out.println(line);
        }
        output.close();
    }
}