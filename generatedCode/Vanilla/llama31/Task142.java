package Vanilla.llama31;
public class Task142 {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println("GCD of 98 and 56 is " + gcd(98, 56));
        System.out.println("GCD of 48 and 18 is " + gcd(48, 18));
        System.out.println("GCD of 399 and 437 is " + gcd(399, 437));
        System.out.println("GCD of 32 and 20 is " + gcd(32, 20));
        System.out.println("GCD of 81 and 153 is " + gcd(81, 153));
    }
}