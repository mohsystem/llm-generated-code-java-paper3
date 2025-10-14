package Vanilla.openai;
class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // Test case 1
        System.out.println(gcd(54, 24)); // Test case 2
        System.out.println(gcd(101, 103)); // Test case 3
        System.out.println(gcd(56, 98)); // Test case 4
        System.out.println(gcd(20, 100)); // Test case 5
    }
}