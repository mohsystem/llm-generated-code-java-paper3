package ourMethod.codestral;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a bash shell command:");
        String command = scanner.nextLine();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}