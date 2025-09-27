package Vanilla.claude;

public class Task57 {
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(0));  // 1
        System.out.println(factorial(1));  // 1
        System.out.println(factorial(3));  // 6
        System.out.println(factorial(7));  // 5040
    }
}
