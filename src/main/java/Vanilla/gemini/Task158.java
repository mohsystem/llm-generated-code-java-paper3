package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task158 {
    public static String executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter command " + (i + 1) + ": ");
            commands[i] = inputReader.readLine();
        }

        for (String command : commands) {
            System.out.println("Executing command: " + command);
            String output = executeCommand(command);
            System.out.println("Output:\n" + output);
        }
        inputReader.close();

    }
}