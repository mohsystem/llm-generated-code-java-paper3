package ourMethod.codestral;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task109 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = scanner.nextLine();
        if(isValidInput(input)) {
            System.out.println("Input is valid.");
        } else {
            System.out.println("Input is invalid.");
        }
        scanner.close();
    }

    private static boolean isValidInput(String input) {
        String regex = "^[a-zA-Z0-9]{5,10}$";
        return Pattern.matches(regex, input);
    }
}