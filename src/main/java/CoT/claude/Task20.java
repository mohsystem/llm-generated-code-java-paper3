package CoT.claude;

public class Task20 {
    public static long digPow(long n, int p) {
        String numStr = String.valueOf(n);
        long sum = 0;
        
        for(int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            sum += Math.pow(digit, p + i);
        }
        
        return sum % n == 0 ? sum / n : -1;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(digPow(89, 1));     // Should print 1
        System.out.println(digPow(92, 1));     // Should print -1
        System.out.println(digPow(695, 2));    // Should print 2
        System.out.println(digPow(46288, 3));  // Should print 51
        System.out.println(digPow(123, 2));    // Should print -1
    }
}
