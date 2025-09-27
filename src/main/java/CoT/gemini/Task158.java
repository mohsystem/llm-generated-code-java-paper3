package CoT.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task158 {

    public static String executeCommand(String userInput) {
        try {
            // Sanitize user input to prevent command injection vulnerabilities
            String sanitizedInput = userInput.replace(";", "").replace("&", "").replace("|", "").replace("<", "").replace(">", "");


            ProcessBuilder pb = new ProcessBuilder(new String[]{"/bin/sh", "-c", sanitizedInput});
            Process p = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = p.waitFor();
            if (exitCode != 0) {
                return "Command execution failed with exit code: " + exitCode;
            }

            return output.toString();

        } catch (IOException | InterruptedException e) {
            return "Error executing command: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test case 1: Enter command (e.g., ls -l):");
        String input1 = scanner.nextLine();
        System.out.println(executeCommand(input1));

        System.out.println("Test case 2: Enter command:");
        String input2 = scanner.nextLine();
        System.out.println(executeCommand(input2));

        System.out.println("Test case 3: Enter command:");
        String input3 = scanner.nextLine();
        System.out.println(executeCommand(input3));

        System.out.println("Test case 4: Enter command:");
        String input4 = scanner.nextLine();
        System.out.println(executeCommand(input4));

        System.out.println("Test case 5: Enter command:");
        String input5 = scanner.nextLine();
        System.out.println(executeCommand(input5));


        scanner.close();
    }
}