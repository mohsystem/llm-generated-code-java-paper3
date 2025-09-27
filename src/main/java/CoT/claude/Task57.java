package CoT.claude;

public class Task57 {
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Input too large, may cause overflow");
        }
        
        long result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println("Factorial of 5: " + calculateFactorial(5));  // 120
            System.out.println("Factorial of 0: " + calculateFactorial(0));  // 1
            System.out.println("Factorial of 10: " + calculateFactorial(10)); // 3628800
            System.out.println("Factorial of 3: " + calculateFactorial(3));   // 6
            System.out.println("Factorial of 7: " + calculateFactorial(7));   // 5040
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
