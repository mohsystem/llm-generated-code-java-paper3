package ourMethod.llama31;
public class Task98 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("Enter an integer: ");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                int input = scanner.nextInt();
                System.out.println("Converted integer: " + input);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }
}