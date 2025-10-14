package Vanilla.openai;
public class Task5 {
    public static void main(String[] args) {
        System.out.println(persistence(39));  // Output: 3
        System.out.println(persistence(999)); // Output: 4
        System.out.println(persistence(4));   // Output: 0
        System.out.println(persistence(25));  // Output: 2
        System.out.println(persistence(77));  // Output: 4
    }

    public static int persistence(long num) {
        int count = 0;
        while (num >= 10) {
            num = multiplyDigits(num);
            count++;
        }
        return count;
    }

    private static long multiplyDigits(long num) {
        long product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }
}