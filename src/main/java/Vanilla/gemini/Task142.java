package Vanilla.gemini;
class Task142 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // Output: 6
        System.out.println(gcd(12, 8));  // Output: 4
        System.out.println(gcd(15, 25)); // Output: 5
        System.out.println(gcd(7, 13));  // Output: 1
        System.out.println(gcd(100, 50));// Output: 50

    }
}