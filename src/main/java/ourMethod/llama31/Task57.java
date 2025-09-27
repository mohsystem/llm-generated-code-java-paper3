package ourMethod.llama31;
public class Task57 {
    public static void main(String[] args) {
        // Test cases
        int[] numbers = {0, 1, 2, 5, 10};
        for (int num : numbers) {
            System.out.println("Factorial of " + num + " is " + factorial(num));
        }
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            // Check for overflow
            if (result > Long.MAX_VALUE / i) {
                throw new ArithmeticException("Factorial result exceeds Long.MAX_VALUE");
            }
        }
        return result;
    }
}