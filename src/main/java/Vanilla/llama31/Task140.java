package Vanilla.llama31;
public class Task140 {
    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        System.out.println("Addition: " + performOperation(10, 5, '+'));
        System.out.println("Subtraction: " + performOperation(10, 5, '-'));
        System.out.println("Multiplication: " + performOperation(10, 5, '*'));
        System.out.println("Division: " + performOperation(10, 5, '/'));
        System.out.println("Invalid Operator: " + performOperation(10, 5, '%'));
    }

    public static double performOperation(double num1, double num2, char operator) {
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
                    return Double.NaN; // or throw an exception
            default:
                return Double.NaN; // or throw an exception
        }
    }
}