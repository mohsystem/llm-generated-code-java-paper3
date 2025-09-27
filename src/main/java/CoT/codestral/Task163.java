package CoT.codestral;
import java.util.Arrays;

public class Task163 {
    public static int longestRun(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLength = 1, currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else if (nums[i] != nums[i - 1]) {
                currentLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
    }
}