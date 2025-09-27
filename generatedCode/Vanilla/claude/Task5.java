package Vanilla.claude;

public class Task5 {
    public static int persistence(long num) {
        int count = 0;
        while (num >= 10) {
            long product = 1;
            while (num > 0) {
                product *= (num % 10);
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39));  // 3
        System.out.println(persistence(999)); // 4
        System.out.println(persistence(4));   // 0
        System.out.println(persistence(25));  // 2
        System.out.println(persistence(777)); // 4
    }
}
