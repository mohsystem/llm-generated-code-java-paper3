package ZeroShot.gemini;
public class Task140 {

    public double calculate(double num1, double num2, char operator) {
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
        Task140 calculator = new Task140();
        System.out.println(calculator.calculate(5, 2, '+'));
        System.out.println(calculator.calculate(5, 2, '-'));
        System.out.println(calculator.calculate(5, 2, '*'));
        System.out.println(calculator.calculate(5, 2, '/'));
        System.out.println(calculator.calculate(5, 0, '/')); 
    }
}