package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task29 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int target1 = 4;
        System.out.println(Arrays.toString(twoSum(test1, target1))); // Output: [0, 2]

        int[] test2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(test2, target2))); // Output: [1, 2]
    }
}