package ourMethod.gpt4o;
public class Task57 {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers are not allowed.");
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));  // 1
        System.out.println(factorial(1));  // 1
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(10)); // 3628800
        System.out.println(factorial(15)); // 1307674368000
    }
}