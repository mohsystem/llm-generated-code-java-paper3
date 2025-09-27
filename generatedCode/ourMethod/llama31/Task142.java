package ourMethod.llama31;
public class Task142 {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("GCD of 32 and 20 is: " + gcd(32, 20));  // Output: 4
        System.out.println("GCD of 98 and 70 is: " + gcd(98, 70));  // Output: 14
        System.out.println("GCD of 399 and 437 is: " + gcd(399, 437));  // Output: 19
        System.out.println("GCD of 12 and 15 is: " + gcd(12, 15));  // Output: 3
        System.out.println("GCD of 7 and 11 is: " + gcd(7, 11));  // Output: 1
    }
}