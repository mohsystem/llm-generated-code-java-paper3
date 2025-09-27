package CoT.gemini;
import java.util.Scanner;

public class Task98 {

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, or return another special value
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(convertToInt(scanner.nextLine()));
        System.out.println(convertToInt(scanner.nextLine()));
        System.out.println(convertToInt(scanner.nextLine()));
        System.out.println(convertToInt(scanner.nextLine()));
        System.out.println(convertToInt(scanner.nextLine()));


        scanner.close();
    }
}