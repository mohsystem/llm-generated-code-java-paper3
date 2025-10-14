package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {

    public static String executeShellCommand(String command) {
        if (!validateCommand(command)) {
            return "Invalid command";
        }

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
        } catch (IOException e) {
            return "Error executing command";
        }

        return output.toString();
    }

    private static boolean validateCommand(String command) {
        // Simple validation example: allow only 'ls' and 'echo' commands
        return command.startsWith("ls") || command.startsWith("echo");
    }

    public static void main(String[] args) {
        System.out.println(executeShellCommand("ls"));
        System.out.println(executeShellCommand("echo Hello, World!"));
        System.out.println(executeShellCommand("rm -rf /"));
        System.out.println(executeShellCommand("echo Secure Coding"));
        System.out.println(executeShellCommand("pwd"));
    }
}