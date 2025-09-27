package ourMethod.codestral;
public class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // Output: 6
        System.out.println(gcd(65, 35)); // Output: 5
        System.out.println(gcd(12, 8)); // Output: 4
        System.out.println(gcd(27, 9)); // Output: 9
        System.out.println(gcd(10, 1)); // Output: 1
    }
}