package ZeroShot.openai;
public class Task57 {
    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(0));  // 1
        System.out.println(factorial(10)); // 3628800
        System.out.println(factorial(3));  // 6
        System.out.println(factorial(7));  // 5040
    }
}