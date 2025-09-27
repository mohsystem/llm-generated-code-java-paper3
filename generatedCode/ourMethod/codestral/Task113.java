package ourMethod.codestral;
import java.util.Scanner;

public class Task113 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input;

        System.out.println("Enter strings to concatenate (enter 'end' to stop):");

        while (true) {
            input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            sb.append(input);
        }

        System.out.println("Concatenated string: " + sb.toString());
    }
}