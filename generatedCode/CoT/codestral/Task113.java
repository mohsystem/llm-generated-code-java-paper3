package CoT.codestral;
import java.util.Scanner;

public class Task113 {
    public static String concatenateStrings(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String input : inputs) {
            sb.append(input);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter string " + (i + 1) + ": ");
            inputs[i] = scanner.nextLine();
        }
        System.out.println("Concatenated string: " + concatenateStrings(inputs));
        scanner.close();
    }
}