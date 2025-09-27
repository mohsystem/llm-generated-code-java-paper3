package CoT.claude;

public class Task140 {
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println(calculate(10, 5, '+')); // Expected: 15.0
            System.out.println(calculate(10, 5, '-')); // Expected: 5.0 
            System.out.println(calculate(10, 5, '*')); // Expected: 50.0
            System.out.println(calculate(10, 5, '/')); // Expected: 2.0
            System.out.println(calculate(10, 0, '/')); // Should throw exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
