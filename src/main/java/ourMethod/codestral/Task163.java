package ourMethod.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task163 {
    public static int longestRun(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        int maxLen = 1;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;
                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
    }
}