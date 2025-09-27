package Vanilla.gemini;
class Task57 {
    public static long factorial(int n) {
        if (n < 0) {
            return -1; // Factorial is not defined for negative numbers
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
        System.out.println(factorial(5));
        System.out.println(factorial(0));
        System.out.println(factorial(10));
        System.out.println(factorial(1));
        System.out.println(factorial(-5));
    }
}