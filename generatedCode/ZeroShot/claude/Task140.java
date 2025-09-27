package ZeroShot.claude;

public class Task140 {
    public static double calculate(double num1, double num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero!");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(calculate(10, 5, '+')); // 15.0
            System.out.println(calculate(10, 5, '-')); // 5.0
            System.out.println(calculate(10, 5, '*')); // 50.0
            System.out.println(calculate(10, 5, '/')); // 2.0
            System.out.println(calculate(10, 2, '*')); // 20.0
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
