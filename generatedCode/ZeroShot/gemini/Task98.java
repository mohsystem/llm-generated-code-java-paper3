package ZeroShot.gemini;
import java.util.Scanner;

class Task98 {
    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, depending on the desired behavior
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