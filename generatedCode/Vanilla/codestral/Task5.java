package Vanilla.codestral;
public class Task5 {
    public static int persistence(long num) {
        int times = 0;
        while (num >= 10) {
            long temp = 1;
            while (num > 0) {
                temp *= num % 10;
                num /= 10;
            }
            num = temp;
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39)); // Outputs: 3
        System.out.println(persistence(999)); // Outputs: 4
        System.out.println(persistence(4)); // Outputs: 0
    }
}