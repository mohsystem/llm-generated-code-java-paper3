package ZeroShot.claude;

public class Task23 {
    public static long findNb(long m) {
        long n = 1;
        long sum = 0;
        while (sum < m) {
            sum += n * n * n;
            if (sum == m) {
                return n;
            }
            n++;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(findNb(1071225));              // Should print 45
        System.out.println(findNb(91716553919377L));      // Should print -1
        System.out.println(findNb(4183059834009L));       // Should print 2022
        System.out.println(findNb(24723578342962L));      // Should print -1
        System.out.println(findNb(135440716410000L));     // Should print 4824
    }
}
