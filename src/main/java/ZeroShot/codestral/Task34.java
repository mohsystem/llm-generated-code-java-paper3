package ZeroShot.codestral;
public class Task34 {
//    public static void main(String[] args) {
//        System.out.println(isNarcissistic(153)); // true
//        System.out.println(isNarcissistic(1652)); // false
//        System.out.println(isNarcissistic(1151322190187639925)); // false
//        System.out.println(isNarcissistic(4887)); // false
//        System.out.println(isNarcissistic(9474)); // true
//    }

    public static boolean isNarcissistic(int number) {
        int originalNumber, result = 0, remainder, n = 0;

        originalNumber = number;

        while (originalNumber != 0) {
            originalNumber /= 10;
            ++n;
        }

        originalNumber = number;

        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }

        return number == result;
    }
}