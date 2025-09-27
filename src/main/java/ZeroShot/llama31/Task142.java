package ZeroShot.llama31;
public class Task142 {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("GCD of 48 and 18 is " + gcd(48, 18));
        System.out.println("GCD of 98 and 56 is " + gcd(98, 56));
        System.out.println("GCD of 1071 and 462 is " + gcd(1071, 462));
        System.out.println("GCD of 399 and 437 is " + gcd(399, 437));
        System.out.println("GCD of 32 and 20 is " + gcd(32, 20));
    }
}