package ZeroShot.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158 {

    public static String executeSafeCommand(String userInput) throws IOException {
        // Sanitize user input to prevent command injection vulnerabilities
        String sanitizedInput = userInput.replace(";", "").replace("&", "").replace("|", "").replace("`", "").replace("$", "").replace("\", "").replace("(", "").replace(")", "");


        // Use ProcessBuilder for better security and control
        ProcessBuilder pb = new ProcessBuilder("echo", sanitizedInput); // Example: using echo

        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new IOException("Command execution failed with exit code: " + exitCode);
        }

        return output.toString();

    }

    public static void main(String[] args) throws IOException {
        System.out.println(executeSafeCommand("test1"));
        System.out.println(executeSafeCommand("test2; ls -l")); // Injection attempt
        System.out.println(executeSafeCommand("test3 | rm -rf /")); // Injection attempt
        System.out.println(executeSafeCommand("test4 && cat /etc/passwd")); // Injection attempt
        System.out.println(executeSafeCommand("test5$(whoami)")); // Injection attempt


    }
}