package CoT.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Task66 {
    public static String executeCommand(String command) {
        if (isValidCommand(command)) {
            StringBuilder output = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", command);
            try {
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                return "Error: " + e.getMessage();
            }
            return output.toString();
        }
        return "Invalid command.";
    }

    private static boolean isValidCommand(String command) {
        // Basic validation, extend as necessary
        return command.matches("^[a-zA-Z0-9_\\- ]+$");
    }

    public static void main(String[] args) {
        System.out.println(executeCommand("echo Hello"));
        System.out.println(executeCommand("ls"));
        System.out.println(executeCommand("pwd"));
        System.out.println(executeCommand("whoami"));
        System.out.println(executeCommand("uname -a"));
    }
}