package ourMethod.llama31;
public class Task44 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Test cases
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number:");
            String input = scanner.nextLine();

            // Input validation
            try {
                int number = Integer.parseInt(input);
                if (number < 0) {
                    System.out.println("Please enter a non-negative number.");
                    continue;
                }

                // Perform operation
                int sum = calculateSum(number);
                System.out.println("The sum of numbers from 1 to " + number + " is " + sum);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}