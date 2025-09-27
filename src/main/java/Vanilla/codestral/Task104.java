package Vanilla.codestral;
import java.util.Scanner;

public class Task104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the buffer: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.println("Enter the string: ");
        String input = scanner.nextLine();
        scanner.close();

        if (input.length() > size) {
            input = input.substring(0, size);
        }

        System.out.println("The string in the buffer is: " + input);
    }
}