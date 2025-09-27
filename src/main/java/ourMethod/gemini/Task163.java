package ourMethod.gemini;
import java.util.Arrays;

class Task163 {
    public int longestRun(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Handle empty or null input
        }

        if (nums.length == 1) {
            return 1; // Handle single-element input
        }
        
        Arrays.sort(nums);

        int longest = 1;
        int current = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else if (nums[i] != nums[i-1]) {
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        longest = Math.max(longest, current); //check for last run

        return longest;
    }

    public static void main(String[] args) {
        Task163 task = new Task163();
        System.out.println(task.longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(task.longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(task.longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(task.longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println(task.longestRun(new int[]{})); //0
    }
}