package Vanilla.gemini;
import java.util.Arrays;

class Task145 {
    public int[] maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
                tempStart = i;
            } else {
                currentMax += nums[i];
            }

            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }
        
        int[] subArray = Arrays.copyOfRange(nums, start, end+1);
        return subArray;
    }

    public static void main(String[] args) {
        Task145 task = new Task145();
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(task.maxSubArray(test1))); // Output: [4, -1, 2, 1]

        int[] test2 = {1};
        System.out.println(Arrays.toString(task.maxSubArray(test2))); // Output: [1]

        int[] test3 = {5, 4, -1, 7, 8};
        System.out.println(Arrays.toString(task.maxSubArray(test3))); // Output: [5, 4, -1, 7, 8]

        int[] test4 = {-2, -1};
        System.out.println(Arrays.toString(task.maxSubArray(test4))); // Output: [-1]

        int[] test5 = {-1, -2, -3, -4};
        System.out.println(Arrays.toString(task.maxSubArray(test5))); // Output: [-1]



    }
}