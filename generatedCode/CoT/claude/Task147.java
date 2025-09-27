package CoT.claude;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }
        
        // Sort array in descending order
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        
        return nums[k - 1];
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] test1 = {3, 2, 1, 5, 6, 4};
        System.out.println("Test 1: " + findKthLargest(test1, 2)); // Expected: 5
        
        int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("Test 2: " + findKthLargest(test2, 4)); // Expected: 4
        
        int[] test3 = {1};
        System.out.println("Test 3: " + findKthLargest(test3, 1)); // Expected: 1
        
        int[] test4 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println("Test 4: " + findKthLargest(test4, 3)); // Expected: 5
        
        int[] test5 = {1, 2, 3, 4, 5};
        System.out.println("Test 5: " + findKthLargest(test5, 1)); // Expected: 5
    }
}
