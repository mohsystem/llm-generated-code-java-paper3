package ZeroShot.llama31;
public class Task57 {
    // Method to find factorial of the given number
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    // Driver method
    public static void main(String[] args) {
        int[] testCases = {0, 1, 2, 5, 10};
        for (int num : testCases) {
            System.out.println("Factorial of " + num + " is " + factorial(num));
        }
    }
}