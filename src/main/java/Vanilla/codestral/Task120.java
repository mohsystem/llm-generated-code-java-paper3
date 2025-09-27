package Vanilla.codestral;
import java.util.Scanner;

public class Task120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your input: ");
        String userInput = scanner.nextLine();
        System.out.println("<html><body><p>" + userInput + "</p></body></html>");
        scanner.close();
    }
}