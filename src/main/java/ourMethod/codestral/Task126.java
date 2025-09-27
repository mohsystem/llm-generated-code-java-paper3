package ourMethod.codestral;
import java.util.Scanner;

public class Task126 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        redirectPage(choice);
    }

    public static void redirectPage(int choice) {
        if (choice == 1) {
            System.out.println("Redirecting to page 1");
        } else if (choice == 2) {
            System.out.println("Redirecting to page 2");
        } else if (choice == 3) {
            System.out.println("Redirecting to page 3");
        } else {
            System.out.println("Invalid choice. Redirecting to default page.");
        }
    }
}