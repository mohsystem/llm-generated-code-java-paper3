package Vanilla.codestral;
// This is a basic outline and does not include validation or error handling.
import java.util.Scanner;
import java.io.IOException;

public class Task66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        try {
            Process process = Runtime.getRuntime().exec(command);
            // Read the output of the command
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}