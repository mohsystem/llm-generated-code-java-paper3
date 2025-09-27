package ourMethod.gpt4o;
import java.util.Arrays;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // Output: 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // Output: 4
        System.out.println(findKthLargest(new int[]{1}, 1)); // Output: 1
        System.out.println(findKthLargest(new int[]{2, 1}, 2)); // Output: 1
        System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 3)); // Output: 5
    }
}