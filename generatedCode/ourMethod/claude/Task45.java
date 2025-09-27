package ourMethod.claude;

public class Task45 {
    public static int performOperation(int num1, int num2, char operation) throws ArithmeticException {
        int result = 0;
        switch (operation) {
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
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println("Test 1: 10 + 5 = " + performOperation(10, 5, '+'));
            System.out.println("Test 2: 10 - 5 = " + performOperation(10, 5, '-'));
            System.out.println("Test 3: 10 * 5 = " + performOperation(10, 5, '*'));
            System.out.println("Test 4: 10 / 5 = " + performOperation(10, 5, '/'));
            System.out.println("Test 5: 10 / 0 = " + performOperation(10, 0, '/')); // Should throw exception
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
