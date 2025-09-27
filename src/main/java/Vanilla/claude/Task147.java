package Vanilla.claude;

import java.util.Arrays;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr1, 2)); // Expected: 5
        
        // Test case 2
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arr2, 4)); // Expected: 4
        
        // Test case 3
        int[] arr3 = {1};
        System.out.println(findKthLargest(arr3, 1)); // Expected: 1
        
        // Test case 4
        int[] arr4 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(findKthLargest(arr4, 3)); // Expected: 5
        
        // Test case 5
        int[] arr5 = {-1, -2, 0, 3, 1};
        System.out.println(findKthLargest(arr5, 1)); // Expected: 3
    }
}
