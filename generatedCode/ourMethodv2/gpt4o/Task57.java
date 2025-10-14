package ourMethodv2.gpt4o;
public class Task57 {
    public static int factorial(int n) {
        if (n < 0) return -1; // Return -1 for invalid input
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // Test case 1: Output should be 120
        System.out.println(factorial(0));  // Test case 2: Output should be 1
        System.out.println(factorial(1));  // Test case 3: Output should be 1
        System.out.println(factorial(10)); // Test case 4: Output should be 3628800
        System.out.println(factorial(-5)); // Test case 5: Output should be -1 (invalid input)
    }
}