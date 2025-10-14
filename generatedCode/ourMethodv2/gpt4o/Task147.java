package ourMethodv2.gpt4o;
import java.util.Arrays;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // Output: 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // Output: 4
        System.out.println(findKthLargest(new int[]{1}, 1)); // Output: 1
        System.out.println(findKthLargest(new int[]{7, 10, 4, 3, 20, 15}, 3)); // Output: 10
        System.out.println(findKthLargest(new int[]{7, 10, 4, 3, 20, 15}, 4)); // Output: 7
    }
}