package ourMethod.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158 {

    public static String executeCommand(String input) {
        StringBuilder output = new StringBuilder();
        try {
            // Validate and sanitize input here
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("sh", "-c", input);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("Command execution failed with code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(executeCommand("echo 'Test 1'"));
        System.out.println(executeCommand("echo 'Test 2'"));
        System.out.println(executeCommand("echo 'Test 3'"));
        System.out.println(executeCommand("echo 'Test 4'"));
        System.out.println(executeCommand("echo 'Test 5'"));
    }
}