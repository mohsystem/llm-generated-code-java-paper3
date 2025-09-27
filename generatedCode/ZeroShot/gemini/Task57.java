package ZeroShot.gemini;
class Task57 {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(0)); // Output: 1
        System.out.println(factorial(1)); // Output: 1
        System.out.println(factorial(5)); // Output: 120
        System.out.println(factorial(10)); // Output: 3628800
        System.out.println(factorial(20)); // Output: 2432902008176640000
    }
}