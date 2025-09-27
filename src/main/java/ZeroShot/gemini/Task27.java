package ZeroShot.gemini;
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
        return 0; // Should never reach here given the problem constraints
    }

    public static void main(String[] args) {
        int[] test1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] test2 = {160, 3, 1719, 19, 11, 13, -21};
        int[] test3 = {1, 1, 2};
        int[] test4 = {2, 4, 6};
        int[] test5 = {1, 3, 5, 2};

        System.out.println(findOutlier(test1)); // 11
        System.out.println(findOutlier(test2)); // 160
        System.out.println(findOutlier(test3)); // 2
        System.out.println(findOutlier(test4)); // Should never reach here
        System.out.println(findOutlier(test5)); // 2

    }
}