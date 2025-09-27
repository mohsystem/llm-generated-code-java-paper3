package ZeroShot.llama31;
public class Task140 {
    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        System.out.println("10 + 5 = " + calculate(10, 5, '+'));
        System.out.println("10 - 5 = " + calculate(10, 5, '-'));
        System.out.println("10 * 5 = " + calculate(10, 5, '*'));
        System.out.println("10 / 5 = " + calculate(10, 5, '/'));
        System.out.println("10 % 5 = " + calculate(10, 5, '%'));
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
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            case '%':
                if (num2 != 0) {
                    return num1 % num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}