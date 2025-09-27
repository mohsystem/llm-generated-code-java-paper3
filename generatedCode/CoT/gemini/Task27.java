package CoT.gemini;
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

        return -1; // Should not reach here as per problem statement
    }

    public static void main(String[] args) {
        int[] test1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] test2 = {160, 3, 1719, 19, 11, 13, -21};
        int[] test3 = {1, 3, 5, 7, 9, 2};
        int[] test4 = {2, 4, 6, 8, 1};
        int[] test5 = {2, 4, 6, 8, 0};


        System.out.println(findOutlier(test1)); // 11
        System.out.println(findOutlier(test2)); // 160
        System.out.println(findOutlier(test3)); // 2
        System.out.println(findOutlier(test4)); // 1
        System.out.println(findOutlier(test5)); // 0



    }
}