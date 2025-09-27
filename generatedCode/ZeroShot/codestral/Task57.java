package ZeroShot.codestral;
public class Task57 {
    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(0)); // 1
        System.out.println(factorial(1)); // 1
        System.out.println(factorial(5)); // 120
        System.out.println(factorial(10)); // 3628800
        System.out.println(factorial(20)); // 2432902008176640000
    }
}