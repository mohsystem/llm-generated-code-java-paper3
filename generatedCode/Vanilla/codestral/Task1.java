package Vanilla.codestral;
public class Task1 {
    public static int number(int[][] arr) {
        int total = 0;
        for (int[] stop : arr) {
            total += stop[0] - stop[1];
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] test1 = {{10, 0}, {3, 5}, {5, 8}};
        int[][] test2 = {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}};
        int[][] test3 = {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}};
        int[][] test4 = {{0, 0}};
        int[][] test5 = {{10, 0}, {2, 5}, {3, 4}};

        System.out.println(number(test1)); // Expected output: 5
        System.out.println(number(test2)); // Expected output: 17
        System.out.println(number(test3)); // Expected output: 9
        System.out.println(number(test4)); // Expected output: 0
        System.out.println(number(test5)); // Expected output: 4
    }
}