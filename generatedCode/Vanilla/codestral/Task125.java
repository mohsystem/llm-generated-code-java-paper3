package Vanilla.codestral;
import java.util.Scanner;

public class Task125 {
    public static void main(String[] args) {
        String[] resources = {"Resource 1", "Resource 2", "Resource 3"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to access a resource: ");
        int index = scanner.nextInt();
        if(index >= 0 && index < resources.length) {
            System.out.println("You accessed: " + resources[index]);
        } else {
            System.out.println("Invalid input. No resource found.");
        }
        scanner.close();
    }
}