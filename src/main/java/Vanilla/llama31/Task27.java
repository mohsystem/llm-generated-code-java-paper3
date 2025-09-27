package Vanilla.llama31;
// Java code
public class Task27 {
    public static int findOutlier(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        int evenNum = 0;
        int oddNum = 0;

        for (int i = 0; i < 3; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
                evenNum = nums[i];
            } else {
                oddCount++;
                oddNum = nums[i];
            }
        }

        return (evenCount > oddCount) ? oddNum : evenNum;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] test2 = {160, 3, 1719, 19, 11, 13, -21};
        int[] test3 = {1, 3, 5, 7, 9, 10};
        int[] test4 = {2, 4, 6, 8, 10, 11};
        int[] test5 = {100, 200, 300, 400, 500, 501};

        System.out.println(findOutlier(test1)); // Output: 11
        System.out.println(findOutlier(test2)); // Output: 160
        System.out.println(findOutlier(test3)); // Output: 10
        System.out.println(findOutlier(test4)); // Output: 11
        System.out.println(findOutlier(test5)); // Output: 501
    }
}