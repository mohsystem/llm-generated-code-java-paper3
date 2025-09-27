package CoT.llama31;
public class Task126 {
    public static void main(String[] args) {
        System.out.println("Enter your choice (1, 2, 3):");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.close();

        switch (choice) {
            case 1:
                System.out.println("Redirecting to Page 1");
                // Code to redirect to Page 1
                break;
            case 2:
                System.out.println("Redirecting to Page 2");
                // Code to redirect to Page 2
                break;
            case 3:
                System.out.println("Redirecting to Page 3");
                // Code to redirect to Page 3
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}