package CoT.gpt4o;
public class Task142 {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Ensure non-negative result
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // 6
        System.out.println(gcd(56, 98)); // 14
        System.out.println(gcd(101, 103)); // 1
        System.out.println(gcd(123456, 789012)); // 12
        System.out.println(gcd(270, 192)); // 6
    }
}