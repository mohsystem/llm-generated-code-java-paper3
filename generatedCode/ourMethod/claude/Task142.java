package ourMethod.claude;

public class Task142 {
    public static int findGCD(int a, int b) {
        // Handle negative numbers by taking absolute values
        a = Math.abs(a);
        b = Math.abs(b);
        
        // Base case - when one number is 0, GCD is the other number
        if (b == 0) {
            return a;
        }
        
        // Recursive Euclidean algorithm to find GCD
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("GCD(48, 36) = " + findGCD(48, 36));  // Should print 12
        System.out.println("GCD(54, 24) = " + findGCD(54, 24));  // Should print 6  
        System.out.println("GCD(7, 13) = " + findGCD(7, 13));    // Should print 1
        System.out.println("GCD(48, 0) = " + findGCD(48, 0));    // Should print 48
        System.out.println("GCD(-54, 24) = " + findGCD(-54, 24)); // Should print 6
    }
}
