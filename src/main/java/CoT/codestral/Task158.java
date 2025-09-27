package CoT.codestral;
import java.util.Scanner;
import java.io.IOException;

public class Task158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data to use in an OS command:");
        String input = scanner.nextLine();
        try {
            Process process = Runtime.getRuntime().exec("echo " + input);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}