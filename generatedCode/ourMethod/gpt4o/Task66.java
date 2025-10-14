package ourMethod.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {

    public static String executeCommand(String command) {
        if (!isValidCommand(command)) {
            return "Invalid command!";
        }

        StringBuilder output = new StringBuilder();
        Process process = null;
        BufferedReader reader = null;

        try {
            process = Runtime.getRuntime().exec(command);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

        } catch (IOException e) {
            return "Error executing command: " + e.getMessage();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
        return output.toString();
    }

    private static boolean isValidCommand(String command) {
        // Basic validation logic
        if (command.contains(";") || command.contains("&") || command.contains("|")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(executeCommand("echo Hello World"));
        System.out.println(executeCommand("ls"));
        System.out.println(executeCommand("pwd"));
        System.out.println(executeCommand("whoami"));
        System.out.println(executeCommand("invalid;command"));
    }
}