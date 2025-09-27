package ourMethod.llama31;
public class Task140 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(calculate(10, 5, '+'));  // Output: 15.0
        System.out.println(calculate(12, 3, '-'));  // Output: 9.0
        System.out.println(calculate(10, 5, '*'));  // Output: 50.0
        System.out.println(calculate(12, 3, '/'));  // Output: 4.0
        System.out.println(calculate(12, 0, '/'));  // Output: Error Division by zero is not allowed.
    }

    public static double calculate(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Error Division by zero is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Error Incorrect Operator Value");
        }
    }
}