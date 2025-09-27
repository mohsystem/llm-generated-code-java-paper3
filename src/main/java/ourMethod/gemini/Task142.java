package ourMethod.gemini;
import java.util.Scanner;

public class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int result = gcd(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);



        System.out.println("Test case 1: GCD(48, 18) = " + gcd(48, 18)); // Expected: 6
        System.out.println("Test case 2: GCD(12, 18) = " + gcd(12, 18)); // Expected: 6
        System.out.println("Test case 3: GCD(7, 13) = " + gcd(7, 13));   // Expected: 1
        System.out.println("Test case 4: GCD(100, 0) = " + gcd(100, 0));  // Expected: 100
        System.out.println("Test case 5: GCD(0, 50) = " + gcd(0, 50));  // Expected: 50

    }

}