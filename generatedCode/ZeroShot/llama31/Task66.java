package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task66 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a Bash command: ");
        String command = reader.readLine();

        // Basic validation (this is very limited and not secure for production use)
        if (command == null || command.isEmpty() || command.contains(";") || command.contains("&") || command.contains("|")) {
            System.out.println("Invalid command format.");
            return;
        }

        try {
            Process process = Runtime.getRuntime().exec(new String[] {"bash", "-c", command});
            printOutput(process.getInputStream());
            printError(process.getErrorStream());
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }

    private static void printOutput(java.io.InputStream inputStream) throws IOException {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
    }

    private static void printError(java.io.InputStream inputStream) throws IOException {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
    }

    public static void testCases() throws IOException {
        String[] testCommands = {
            "echo Hello World",
            "ls -l",
            "pwd",
            "invalid;command",
            "valid command"
        };

        for (String command : testCommands) {
            System.out.println("Command: " + command);
            try {
                Process process = Runtime.getRuntime().exec(new String[] {"bash", "-c", command});
                printOutput(process.getInputStream());
                printError(process.getErrorStream());
                process.waitFor();
            } catch (Exception e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        testCases();
    }
}