package ZeroShot.gemini;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println(gcd(12, 18)); // Output: 6
        System.out.println(gcd(48, 18)); // Output: 6
        System.out.println(gcd(17, 23)); // Output: 1
        System.out.println(gcd(0, 5)); // Output: 5
        System.out.println(gcd(10, 0)); // Output: 10


    }
}