package ZeroShot.codestral;
import java.util.Scanner;

public class Task113 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder concatenatedString = new StringBuilder();
        System.out.println("Enter strings to concatenate (enter 'stop' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            concatenatedString.append(input);
        }
        System.out.println("Concatenated string: " + concatenatedString.toString());
    }
}