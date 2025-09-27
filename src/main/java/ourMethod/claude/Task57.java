package ourMethod.claude;

public class Task57 {
    public static long factorial(long n) {
        // Input validation
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Number too large, would cause overflow");
        }
        
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Calculate factorial
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        long[] tests = {0, 1, 5, 10, 20};
        
        for (long test : tests) {
            try {
                System.out.println("Factorial of " + test + " = " + factorial(test));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
