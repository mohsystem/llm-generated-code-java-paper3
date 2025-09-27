package CoT.codestral;
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
                if (num2 != 0)
                    return num1 / num2;
                else
                    throw new ArithmeticException("Division by zero is not allowed.");
            default:
                throw new IllegalArgumentException("Invalid operator. Only +, -, *, / are allowed.");
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate(10, 5, '+')); // Output: 15.0
        System.out.println(calculate(10, 5, '-')); // Output: 5.0
        System.out.println(calculate(10, 5, '*')); // Output: 50.0
        System.out.println(calculate(10, 5, '/')); // Output: 2.0
        System.out.println(calculate(10, 0, '/')); // Throws ArithmeticException: Division by zero is not allowed.
        System.out.println(calculate(10, 5, '^')); // Throws IllegalArgumentException: Invalid operator. Only +, -, *, / are allowed.
    }
}