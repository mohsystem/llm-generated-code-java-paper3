package ZeroShot.codestral;
// This is a simplified example and doesn't include any security measures.
// A real-world application would need to include proper command validation and error handling.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task66 {
    private static Map<String, String[]> commands = new HashMap<>();

    static {
        commands.put("ls", new String[]{"/bin/sh", "-c", "ls"});
        // Add more commands as needed
    }

    public static String executeCommand(String command) throws IOException {
        if (commands.containsKey(command)) {
            Process process = new ProcessBuilder(commands.get(command)).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString();
        } else {
            return "Command not found.";
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(executeCommand("ls"));
    }
}