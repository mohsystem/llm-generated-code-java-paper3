package Vanilla.codestral;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int originalNumber, result = 0, n = 0;

        originalNumber = number;

        while (originalNumber != 0) {
            originalNumber /= 10;
            ++n;
        }

        originalNumber = number;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            result += Math.pow(digit, n);
            originalNumber /= 10;
        }

        return number == result;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153)); // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(115132219018763992565095597973971522401)); // false
        System.out.println(isNarcissistic(4887)); // false
        System.out.println(isNarcissistic(8208)); // true
    }
}