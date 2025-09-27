package Vanilla.codestral;
public class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(36, 60)); // 12
        System.out.println(gcd(100, 50)); // 50
        System.out.println(gcd(7, 9)); // 1
        System.out.println(gcd(24, 36)); // 12
        System.out.println(gcd(15, 15)); // 15
    }
}