package ourMethod.codestral;
public class Task140 {
    public static void main(String[] args) {
        test(10, 5, '+');
        test(10, 5, '-');
        test(10, 5, '*');
        test(10, 5, '/');
        test(10, 0, '/');
    }

    public static void test(double num1, double num2, char operator) {
        try {
            System.out.println(calculate(num1, num2, operator));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

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
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator. Supported operators are +, -, *, /");
        }
    }
}