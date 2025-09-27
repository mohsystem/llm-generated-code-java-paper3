package ZeroShot.gemini;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Task29 {
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.contains(complement)) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == complement && i != j) {
                        return new int[]{j, i};
                    }
                }
            }
            seen.add(nums[i]);
        }
        return new int[0]; // Should never reach here given the problem constraints
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{10, 20, 30, 40}, 50)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4}, -5)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));


    }
}