package CoT.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task158 {

    public static String executeCommand(String userInput) {
        StringBuilder output = new StringBuilder();
        Process process;
        try {
            // Sanitize user input by allowing only a safe command like 'echo'
            process = Runtime.getRuntime().exec(new String[]{"sh", "-c", "echo " + sanitize(userInput)});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
        return output.toString();
    }

    private static String sanitize(String input) {
        // Allow only alphanumeric and basic punctuation
        return input.replaceAll("[^a-zA-Z0-9 .,-]", "");
    }

    public static void main(String[] args) {
        System.out.println(executeCommand("Hello World"));
        System.out.println(executeCommand("Hello; rm -rf /"));
        System.out.println(executeCommand("1234567890"));
        System.out.println(executeCommand("!@#$%^&*()_+"));
        System.out.println(executeCommand("Java test"));
    }
}