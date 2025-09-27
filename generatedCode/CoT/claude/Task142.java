package CoT.claude;

public class Task142 {
    public static int findGCD(int a, int b) {
        // Handle negative numbers by converting to positive
        a = Math.abs(a);
        b = Math.abs(b);
        
        // Using Euclidean algorithm to find GCD
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(findGCD(48, 36));  // Should print 12
        System.out.println(findGCD(54, 24));  // Should print 6
        System.out.println(findGCD(7, 13));   // Should print 1
        System.out.println(findGCD(48, -36)); // Should print 12
        System.out.println(findGCD(0, 5));    // Should print 5
    }
}
