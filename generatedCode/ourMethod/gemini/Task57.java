package ourMethod.gemini;
import java.util.Scanner;

public class Task57 {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0) {
            return 1;
        } else {
            long result = 1;
            for (int i = 1; i <= n; i++) {
                if (Long.MAX_VALUE / result < i) {  // Check for potential overflow
                    throw new ArithmeticException("Factorial result too large for long data type.");
                }
                result *= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(factorial(0)); // Expected: 1
        System.out.println(factorial(1)); // Expected: 1
        System.out.println(factorial(5)); // Expected: 120
        System.out.println(factorial(10)); // Expected: 3628800
        System.out.println(factorial(20)); // Expected: 2432902008176640000

        scanner.close();


    }
}