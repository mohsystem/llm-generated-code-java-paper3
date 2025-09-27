package ZeroShot.codestral;
import java.util.*;

public class Task163 {
    public static int longestRun(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int longestSequence = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }

        return longestSequence > 0 ? longestSequence : 1;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // 1
    }
}