package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task158 {

    public static void main(String[] args) {
        Task158 task = new Task158();
        String[] testCases = {"echo HelloWorld", "dir", "ls", "whoami", "echo Test"};

        for (String command : testCases) {
            System.out.println("Output for command: " + command);
            task.executeCommand(command);
        }
    }

    public void executeCommand(String userInput) {
        if (!isValidInput(userInput)) {
            System.out.println("Invalid command.");
            return;
        }

        try {
            Process process = Runtime.getRuntime().exec(userInput);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidInput(String input) {
        // Basic validation to ensure input is not malicious
        return input.matches("^[a-zA-Z0-9_\\- ]+$");
    }
}