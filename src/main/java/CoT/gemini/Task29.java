package CoT.gemini;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        return new int[0]; // Should not happen since a solution is guaranteed
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // Output: [0, 2]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // Output: [1, 2]
        
        int[] nums3 = {2,7,11,15};
        int target3 = 9;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); // Output: [0, 1]

        int[] nums4 = {3,3};
        int target4 = 6;
        System.out.println(Arrays.toString(twoSum(nums4, target4))); // Output: [0, 1]
        
        int[] nums5 = {3,2,3};
        int target5 = 6;
        System.out.println(Arrays.toString(twoSum(nums5, target5))); // Output: [0, 2]

    }
}