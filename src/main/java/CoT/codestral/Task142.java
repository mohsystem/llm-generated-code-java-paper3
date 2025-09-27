package CoT.codestral;
public class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // Output: 6
        System.out.println(gcd(123, 456)); // Output: 3
        System.out.println(gcd(7, 7)); // Output: 7
        System.out.println(gcd(0, 0)); // Output: 0
        System.out.println(gcd(12, 0)); // Output: 12
    }
}