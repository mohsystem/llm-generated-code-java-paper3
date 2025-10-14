package ourMethod.openai;
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
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate(5, 3, '+'));
        System.out.println(calculate(5, 3, '-'));
        System.out.println(calculate(5, 3, '*'));
        System.out.println(calculate(5, 3, '/'));
        System.out.println(calculate(5, 0, '/'));
    }
}