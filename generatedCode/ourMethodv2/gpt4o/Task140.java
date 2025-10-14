package ourMethodv2.gpt4o;
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
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate(10, 5, '+')); // 15.0
        System.out.println(calculate(10, 5, '-')); // 5.0
        System.out.println(calculate(10, 5, '*')); // 50.0
        System.out.println(calculate(10, 5, '/')); // 2.0
        try {
            System.out.println(calculate(10, 0, '/')); // Exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}