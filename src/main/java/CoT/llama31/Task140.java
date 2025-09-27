package CoT.llama31;
// Java code
public class Task140 {
    public static double calculate(double num1, double num2, char op) {
        switch (op) {
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
                    throw new ArithmeticException("Division by zero");
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate(10, 5, '+'));   // Output: 15.0
        System.out.println(calculate(10, 5, '-'));   // Output: 5.0
        System.out.println(calculate(10, 5, '*'));   // Output: 50.0
        System.out.println(calculate(10, 5, '/'));   // Output: 2.0
        try {
            System.out.println(calculate(10, 0, '/')); // This will throw an exception
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}