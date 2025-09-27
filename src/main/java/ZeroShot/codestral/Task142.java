package ZeroShot.codestral;
public class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18));  // Output: 6
        System.out.println(gcd(100, 50)); // Output: 50
        System.out.println(gcd(35, 20));  // Output: 5
        System.out.println(gcd(60, 72));  // Output: 12
        System.out.println(gcd(12, 18));  // Output: 6
    }
}