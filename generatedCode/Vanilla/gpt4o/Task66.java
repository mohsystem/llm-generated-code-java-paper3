package Vanilla.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task66 {
    public static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
        } catch (Exception e) {
            return "Error executing command.";
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(executeCommand("echo Hello World"));
        System.out.println(executeCommand("pwd"));
        System.out.println(executeCommand("ls"));
        System.out.println(executeCommand("whoami"));
        System.out.println(executeCommand("date"));
    }
}