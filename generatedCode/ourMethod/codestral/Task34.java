package ourMethod.codestral;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        int originalNumber, result = 0, remainder;
        int n = String.valueOf(number).length();

        originalNumber = number;

        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }

        return number == result;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153)); // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(1634)); // true
        System.out.println(isNarcissistic(8208)); // true
        System.out.println(isNarcissistic(9474)); // false
    }
}