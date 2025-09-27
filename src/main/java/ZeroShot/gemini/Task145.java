package ZeroShot.gemini;
import java.util.Arrays;

class Task145 {
    public int maxSubArraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Task145 task = new Task145();
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] test2 = {1};
        int[] test3 = {5, 4, -1, 7, 8};
        int[] test4 = {-1};
        int[] test5 = {-2, -1};


        System.out.println(task.maxSubArraySum(test1)); // Output: 6
        System.out.println(task.maxSubArraySum(test2)); // Output: 1
        System.out.println(task.maxSubArraySum(test3)); // Output: 23
        System.out.println(task.maxSubArraySum(test4)); // Output: -1
        System.out.println(task.maxSubArraySum(test5)); // Output: -1

    }
}