package ourMethod.claude;

public class Task140 {
    public static double calculate(double num1, double num2, char operator) {
        double result = 0;
        
        switch(operator) {
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
                if(num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero!");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator! Use +, -, * or /");
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println(calculate(10, 5, '+')); // Should print 15.0
            System.out.println(calculate(10, 5, '-')); // Should print 5.0 
            System.out.println(calculate(10, 5, '*')); // Should print 50.0
            System.out.println(calculate(10, 5, '/')); // Should print 2.0
            System.out.println(calculate(10, 0, '/')); // Should throw exception
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
