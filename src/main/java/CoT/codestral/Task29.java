package CoT.codestral;
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
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] result1 = twoSum(test1, 4);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] test2 = {3, 2, 4};
        int[] result2 = twoSum(test2, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] test3 = {1, 3, 5, 7};
        int[] result3 = twoSum(test3, 8);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] test4 = {2, 7, 11, 15};
        int[] result4 = twoSum(test4, 9);
        System.out.println("[" + result4[0] + ", " + result4[1] + "]");

        int[] test5 = {-3, 4, 3, 90};
        int[] result5 = twoSum(test5, 0);
        System.out.println("[" + result5[0] + ", " + result5[1] + "]");
    }
}