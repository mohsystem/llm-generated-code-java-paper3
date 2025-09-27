package CoT.codestral;
// Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {
    public static void main(String[] args) {
        String command = "ls -l"; // replace with the command you want to execute
        try {
            if (isValidCommand(command)) {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Invalid command");
            }
        } catch (IOException e) {
            System.out.println("Error executing command");
        }
    }

    private static boolean isValidCommand(String command) {
        // Add your validation logic here
        // For simplicity, this function always returns true
        return true;
    }
}