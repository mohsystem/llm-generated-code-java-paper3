package ZeroShot.claude;

public class Task57 {
    public static long factorial(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        
        long result = 1;
        for(int i = 2; i <= n; i++) {
            if (result > Long.MAX_VALUE/i) return -1; //check overflow
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testCases = {5, 0, 10, 3, 7};
        
        for(int test : testCases) {
            System.out.println("Factorial of " + test + " = " + factorial(test));
        }
    }
}
