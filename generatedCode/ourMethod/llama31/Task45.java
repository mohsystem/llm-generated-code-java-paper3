package ourMethod.llama31;
public class Task45 {
    public static void main(String[] args) {
        try {
            // Test cases
            for (int i = 0; i < 5; i++) {
                String input = getInputFromUser("Enter a number: ");
                int number = Integer.parseInt(input);
                performOperation(number);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static String getInputFromUser(String prompt) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void performOperation(int number) {
        try {
            // Example operation: division by user input
            int result = 100 / number;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}