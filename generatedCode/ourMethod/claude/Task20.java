package ourMethod.claude;

public class Task20 {
    public static long digPow(long n, int p) {
        if (n <= 0 || p <= 0) {
            return -1;
        }
        
        // Convert number to string to process digits
        String numStr = String.valueOf(n);
        long sum = 0;
        int currentPower = p;
        
        // Calculate sum of powered digits
        for (char digit : numStr.toCharArray()) {
            int num = digit - '0';
            long powResult = 1;
            
            // Manual power calculation to prevent overflow
            for (int i = 0; i < currentPower; i++) {
                if (powResult > Long.MAX_VALUE / num) {
                    return -1; // Prevent overflow
                }
                powResult *= num;
            }
            
            if (sum > Long.MAX_VALUE - powResult) {
                return -1; // Prevent overflow
            }
            sum += powResult;
            currentPower++;
        }
        
        // Check if there exists a k that satisfies the equation
        if (sum % n == 0) {
            long k = sum / n;
            if (k > 0) {
                return k;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(digPow(89, 1));      // Should print 1
        System.out.println(digPow(92, 1));      // Should print -1
        System.out.println(digPow(695, 2));     // Should print 2
        System.out.println(digPow(46288, 3));   // Should print 51
        System.out.println(digPow(0, 1));       // Should print -1
    }
}
