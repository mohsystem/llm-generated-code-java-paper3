package ZeroShot.codestral;
import java.util.Scanner;
import java.io.IOException;

public class Task158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String command = scanner.nextLine();
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}