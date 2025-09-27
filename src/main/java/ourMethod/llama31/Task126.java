package ourMethod.llama31;
public class Task126 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice (1, 2, or 3):");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Redirecting to Page 1");
                        System.out.println("You are now on Page 1");
                        break;
                    case 2:
                        System.out.println("Redirecting to Page 2");
                        System.out.println("You are now on Page 2");
                        break;
                    case 3:
                        System.out.println("Redirecting to Page 3");
                        System.out.println("You are now on Page 3");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                break; // Exit the loop after valid input
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}