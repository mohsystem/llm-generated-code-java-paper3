package ourMethod.claude;

public class Task23 {
    public static long findNb(long m) {
        if (m <= 0) {
            return -1;
        }
        
        long n = 1;
        long sum = 0;
        
        while (sum < m) {
            sum += (long)Math.pow(n, 3);
            if (sum == m) {
                return n;
            }
            if (sum > m || sum < 0) { // Check for overflow
                return -1;
            }
            n++;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(findNb(1071225)); // Should print 45
        System.out.println(findNb(91716553919377L)); // Should print -1
        System.out.println(findNb(4183059834009L)); // Should print 2022
        System.out.println(findNb(24723578342962L)); // Should print -1
        System.out.println(findNb(135440716410000L)); // Should print 4824
    }
}
