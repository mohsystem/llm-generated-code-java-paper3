package CoT.codestral;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int originalNumber, remainder, result = 0, n = 0;

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

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(370));  // true
        System.out.println(isNarcissistic(371));  // true
        System.out.println(isNarcissistic(407));  // true
        System.out.println(isNarcissistic(1652)); // false
    }
}