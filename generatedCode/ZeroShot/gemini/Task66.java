package ZeroShot.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {

    public static String executeCommand(String command) throws IOException {
        if (!isValidCommand(command)) {
            return "Invalid command";
        }

        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }


    private static boolean isValidCommand(String command) {
        // Basic validation (customize as needed)
        return command != null && !command.isEmpty() && !command.contains(";") && !command.contains("|");
    }


    public static void main(String[] args) throws IOException {
        System.out.println(executeCommand("ls -l"));
        System.out.println(executeCommand("pwd"));
        System.out.println(executeCommand("date"));
        System.out.println(executeCommand("whoami"));
        System.out.println(executeCommand("; rm -rf *")); // Invalid command example
    }
}