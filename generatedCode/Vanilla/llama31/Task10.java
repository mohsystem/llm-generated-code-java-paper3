package Vanilla.llama31;
// Java code
public class Task10 {
    public static void main(String[] args) {
        System.out.println(sumOfRange(1, 0)); // Expected: 1
        System.out.println(sumOfRange(1, 2)); // Expected: 3
        System.out.println(sumOfRange(0, 1)); // Expected: 1
        System.out.println(sumOfRange(1, 1)); // Expected: 1
        System.out.println(sumOfRange(-1, 0)); // Expected: -1
        System.out.println(sumOfRange(-1, 2)); // Expected: 2
    }

    public static int sumOfRange(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }
}