package ourMethod.openai;
public class Task5 {
    public static int persistence(int num) {
        int count = 0;
        while (num >= 10) {
            num = multiplyDigits(num);
            count++;
        }
        return count;
    }

    private static int multiplyDigits(int num) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39));   // Output: 3
        System.out.println(persistence(999));  // Output: 4
        System.out.println(persistence(4));    // Output: 0
        System.out.println(persistence(25));   // Output: 2
        System.out.println(persistence(77));   // Output: 4
    }
}