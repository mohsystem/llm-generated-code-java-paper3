package Vanilla.openai;
import java.util.Scanner;

public class Task113 {
    public static String concatenateStrings(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter strings to concatenate (comma separated):");
            String input = scanner.nextLine();
            String[] strings = input.split(",");
            System.out.println("Concatenated result: " + concatenateStrings(strings));
        }
        scanner.close();
    }
}