package ourMethod.claude;

public class Task10 {
    public static int getSum(int a, int b) {
        if (a == b) return a;
        
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        
        // Using arithmetic progression sum formula to avoid overflow
        int n = end - start + 1;
        // Cast to long to prevent integer overflow during calculation
        long sum = ((long)n * (start + end)) / 2;
        
        // Check if result is within integer bounds
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            throw new ArithmeticException("Sum exceeds integer bounds");
        }
        
        return (int)sum;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getSum(1, 0));  // Expected: 1
        System.out.println(getSum(1, 2));  // Expected: 3 
        System.out.println(getSum(0, 1));  // Expected: 1
        System.out.println(getSum(1, 1));  // Expected: 1
        System.out.println(getSum(-1, 2)); // Expected: 2
    }
}
