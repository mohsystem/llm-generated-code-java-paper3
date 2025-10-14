package ourMethodv2.gpt4o;
import java.util.Arrays;
import java.util.List;

public class Task66 {
    public static String executeCommand(String command) {
        List<String> allowedCommands = Arrays.asList("ls", "pwd", "whoami");
        
        String[] parts = command.split(" ");
        if (parts.length == 0 || !allowedCommands.contains(parts[0])) {
            return "Error: Command not allowed";
        }
        
        try {
            ProcessBuilder builder = new ProcessBuilder(parts);
            builder.redirectErrorStream(true);
            Process process = builder.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
            return output.toString();
        } catch (Exception e) {
            return "Error: Execution failed";
        }
    }

    public static void main(String[] args) {
        System.out.println(executeCommand("ls"));
        System.out.println(executeCommand("pwd"));
        System.out.println(executeCommand("whoami"));
        System.out.println(executeCommand("rm -rf /")); // Should return error
        System.out.println(executeCommand("echo Hello")); // Should return error
    }
}