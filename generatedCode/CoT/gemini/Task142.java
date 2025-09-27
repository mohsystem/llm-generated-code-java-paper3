package CoT.gemini;
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
        System.out.println(gcd(48, 18)); // Expected: 6
        System.out.println(gcd(12, 8));  // Expected: 4
        System.out.println(gcd(15, 25)); // Expected: 5
        System.out.println(gcd(7, 11));  // Expected: 1
        System.out.println(gcd(0, 5));   // Expected: 5
    }
}