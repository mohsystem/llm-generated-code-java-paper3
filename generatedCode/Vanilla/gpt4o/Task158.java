package Vanilla.gpt4o;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Task158 {
    public static String runCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            output.append("Error: ").append(e.getMessage());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(runCommand("echo Test 1"));
        System.out.println(runCommand("echo Test 2"));
        System.out.println(runCommand("echo Test 3"));
        System.out.println(runCommand("echo Test 4"));
        System.out.println(runCommand("echo Test 5"));
    }
}