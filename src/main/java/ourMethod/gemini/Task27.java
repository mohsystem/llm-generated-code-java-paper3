package ourMethod.gemini;
import java.util.Arrays;

class Task27 {
    public static int findOutlier(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < 3; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        boolean isEvenOutlier = oddCount > evenCount;

        for (int num : arr) {
            if (isEvenOutlier) {
                if (num % 2 == 0) {
                    return num;
                }
            } else {
                if (num % 2 != 0) {
                    return num;
                }
            }
        }

        return 0; // Should never reach here given problem constraints
    }

    public static void main(String[] args) {
        int[] test1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] test2 = {160, 3, 1719, 19, 11, 13, -21};
        int[] test3 = {1, 3, 5, 7, 8, 9, 11};
        int[] test4 = {2, 4, 6, 8, 9, 10, 12};
        int[] test5 = {2, 4, 6, 8, 10, 12, 14, 1, 16, 18};

        System.out.println(findOutlier(test1)); // 11
        System.out.println(findOutlier(test2)); // 160
        System.out.println(findOutlier(test3)); // 8
        System.out.println(findOutlier(test4)); // 9
        System.out.println(findOutlier(test5)); // 1
    }
}