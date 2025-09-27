package CoT.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task66 {

    public static String executeCommand(String command) throws IOException {
        if (!isValidCommand(command)) {
            return "Invalid command format or potentially harmful command.";
        }

        ProcessBuilder processBuilder = new ProcessBuilder(Arrays.asList("/bin/bash", "-c", command));
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            return "Command execution interrupted.";
        }

        return output.toString();
    }

    private static boolean isValidCommand(String command) {
        // Basic validation against potentially harmful commands
        List<String> disallowedCommands = Arrays.asList("|", ";", "&", "&&", "||", "<", ">", "`", "$", "(", ")");
        for (String disallowed : disallowedCommands) {
            if (command.contains(disallowed)) {
                return false;
            }
        }

        // Allow only ls, date, pwd, whoami commands
        Pattern allowedCommands = Pattern.compile("^(ls|date|pwd|whoami)(\\s+.*)?$");
        Matcher matcher = allowedCommands.matcher(command);
        return matcher.matches();
    }


    public static void main(String[] args) throws IOException {
        String[] testCommands = {
                "ls -l",
                "date",
                "pwd",
                "whoami",
                "rm -rf /" // Invalid command
        };

        for (String command : testCommands) {
            System.out.println("Command: " + command);
            System.out.println("Result:\n" + executeCommand(command));
            System.out.println("---");
        }
    }
}