package ZeroShot.codestral;
import java.util.*;

public class Task29 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 4))); // Output: [0, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6))); // Output: [1, 2]
    }
}