package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task158 {

    public static String executeCommandSecurely(String input) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Use a fixed command and pass the input as an argument
        processBuilder.command("bash", "-c", "echo", input);

        StringBuilder output = new StringBuilder();
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter input: ");
            String input = scanner.nextLine();
            System.out.println("Output: " + executeCommandSecurely(input));
        }
        scanner.close();
    }
}