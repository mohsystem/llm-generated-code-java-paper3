package Vanilla.gemini;
import java.util.Arrays;

class Task27 {
    public static int findOutlier(int[] arr) {
        int evenCount = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }

        boolean isEvenOutlier = evenCount < 2;

        for (int num : arr) {
            if (isEvenOutlier) {
                if (num % 2 != 0) {
                    return num;
                }
            } else {
                if (num % 2 == 0) {
                    return num;
                }
            }
        }

        return 0; // Should not reach here given the problem constraints
    }

    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36})); // 11
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21})); // 160
        System.out.println(findOutlier(new int[]{1, 1, 2})); // 2
        System.out.println(findOutlier(new int[]{2, 6, 8, 10, 3})); // 3
        System.out.println(findOutlier(new int[]{1, 3, 5, 7, 8, 9})); // 8

    }
}