package Vanilla.codestral;
public class Task57 {
    public static long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // Output: 120
        System.out.println(factorial(0));  // Output: 1
        System.out.println(factorial(1));  // Output: 1
        System.out.println(factorial(10)); // Output: 3628800
        System.out.println(factorial(15)); // Output: 1307674368000
    }
}